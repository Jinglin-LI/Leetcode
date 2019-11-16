/*
For a undirected graph with tree characteristics, we can choose any node as the root. 
The result graph is then a rooted tree. 
Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). 
Given such a graph, write a function to find all the MHTs and return a list of their root labels.

Format
The graph contains n nodes which are labeled from 0 to n - 1. 
You will be given the number n and a list of undirected edges (each edge is a pair of labels).
You can assume that no duplicate edges will appear in edges. 
Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

Example 1:
Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]
        0
        |
        1
       / \
      2   3
return [1]

Example 2:
Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
     0  1  2
      \ | /
        3
        |
        4
        |
        5
return [3, 4]

Hint:
How many MHTs can a graph have at most?

Note:
(1) According to the definition of tree on Wikipedia: 
“a tree is an undirected graph in which any two vertices are connected by exactly one path. 
In other words, any connected graph without simple cycles is a tree.”

(2) The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
*/
/*
剥洋葱。存储最末的叶子（以nbNumber为计数，nbNumber == 1时为叶子），删除（以n--的形式），最后由于“有树的性质”，n <= 2时便是答案。
先利用adjList<Integer, List<Integer>>构造图。利用nbNumber记录每一个node的邻居的个数。第一轮用for遍历找最末的叶子，之后遍历其父母。

*/

public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> leaf = new ArrayList<>();
        if (n <= 1) {
            leaf.add(0);
            return leaf;
        }
        
        HashMap<Integer, List<Integer>> hm = new HashMap<>();               // construct the graph
        for (int i = 0; i < n; i++)
            hm.put(i, new ArrayList<>());
        int[] nbNumber = new int[n];
        for (int[] edge : edges) {
            nbNumber[edge[0]]++;
            nbNumber[edge[1]]++;
            hm.get(edge[0]).add(edge[1]);
            hm.get(edge[1]).add(edge[0]);
        }
        
        for (int i = 0; i < n; i++) {                                       // 第一轮找叶子
            if (hm.get(i).size() == 1)
                leaf.add(i);
        }
        
        while (n > 2) {
            List<Integer> newLeaf = new ArrayList<>();
            for (int eachLeaf : leaf) {
                n--;
                for (int parent : hm.get(eachLeaf)) {
                    if (--nbNumber[parent] == 1) {
                        newLeaf.add(parent);
                    }
                }
                leaf = newLeaf;                                             // 新叶子
            }
        }
        return leaf;
    }
        
    // find the size of the q for each time, create a new res, return the last one. 这道题注意，int[][] 给出的是edge， 并不是prerequisite, 所以是无向图。要有两个degree， 两个hm. 
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        if (n <= 1) {
            res.add(0);
            return res;
        }
        if (n <= 0 || edges == null || edges.length == 0 || edges[0].length == 0) {
            return res;
        }
        int[] degree = new int[n];

        for (int[] edge : edges) {
            list.get(edge[1]).add(edge[0]);
            list.get(edge[0]).add(edge[1]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 1) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int size = q.size();
            res = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int temp = q.poll();
                res.add(temp);
                if (list.get(temp) != null) {
                    for (int each : list.get(temp)) {
                        degree[each]--;
                        if (degree[each] == 1) {
                            q.add(each);
                        }
                    }
                }
            }   
        }
        return res;
    }
}
