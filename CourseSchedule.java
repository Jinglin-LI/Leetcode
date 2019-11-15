/*
There are a total of n courses you have to take, labeled from 0 to n - 1.
Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
For example:
2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
*/
// For the Topological sort method, reference: http://blog.csdn.net/ljiabin/article/details/45846837
// 构建图，[[],[],[],[]], index为先修课的名称（0,1,2）. 从“入度”为0的节点加入到Q中，把这个节点（先修课）后面的课程的入度减去1.
// 用count记录numCourses, 用以“删除”节点。


public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] status = new int[numCourses];                             // 0 , not visited; 1, visited and in the stack; 2, visited and out of stack
        for (int i = 0; i < numCourses; i++) {                          // from the first edge, 0
            if (status[i] == 0) {                                       // not visited
                if (!DFS(i, prerequisites, status))
                    return false;
            }
        }
        return true;
    }
    private boolean DFS(int index, int[][] prerequisites, int[] status) {
        if (status[index] == 1)                                         // visited
            return false;
        status[index] = 1;
        for (int[] p : prerequisites) {                                 // note the usage of int[] p: prerequisites
            if (p[0] == index && status[p[1]] != 2) {                   // don't consider the edge which is out of stack for recurse
                if (!DFS(p[1], prerequisites, status))
                    return false;
            }
        }
        status[index] = 2;
        return true;
    }
	
	// DFS2, Find circle， visited控制是否有circle
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        List[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList();
        }
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, visited, i)) {
                return false;
            }
        }
        return true;
    } 
    private boolean dfs(List[] graph, boolean[] visited, int course) {
        if (visited[course]) {
            return false;
        } else {
            visited[course] = true;
        }
        // for (int i = 0; i < graph[course].size(); i++) {
        //     if (!dfs(graph, visited, (int)graph[course].get(i))) {
        //         return false;
        //     }
        // }
        for (Object i : graph[course]) {
            if (!dfs(graph, visited, (int)i)) {
                return false;
            }
        }
        visited[course] = false;
        return true;
    }
	// 入度
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
		List<List<Integer>> posts = new ArrayList<>();
		for (int i = 0; i < numCourses; i++) {
			posts.add(new ArrayList<>());
		}
		int[] preNums = new int[numCourses];
		for (int i = 0; i < prerequisites.length; i++) {
			posts.get(prerequisites[i][1]).add(prerequisites[i][0]);
			preNums[prerequisites[i][0]]++;			// 入度，有多少节点入这个节点
		}
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (preNums[i] == 0)
				q.add(i);
		}
		int count = numCourses;
		while (!q.isEmpty()) {
			int x = q.poll();
			for (int i : posts.get(x)) {
				if (--preNums[i] == 0)
					q.add(i);
			}
			count--;
		}
		return count == 0;
	}
	
	// 基本方法一样。用hm取代List<List<Integer>>
	public boolean canFinish3(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        int[] degree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            if (!hm.containsKey(prerequisite[1])) {
                hm.put(prerequisite[1], new ArrayList<Integer>());
            }
            hm.get(prerequisite[1]).add(prerequisite[0]);
            degree[prerequisite[0]]++;
            
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                q.add(i);
            }
        }
        int count = numCourses;
        while (!q.isEmpty()) {
        	count--;
            int temp = q.poll();
		
	    /* 好奇怪的用法...
            for (int i = 0; hm.containsKey(temp) && i < hm.get(temp).size(); i++) {
                if (--degree[hm.get(temp).get(i)] == 0)
                    q.add(hm.get(temp).get(i));
            }
	    */

	    if (hm.get(temp) != null) {              // 为了防止空指针
                for (Integer neighbor : hm.get(temp)) {
                    if (--degree[neighbor] == 0) {
                        q.add(neighbor);
                    }
                }
            }
        }
        return count == 0;
    }
}
