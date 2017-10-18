/*
Given n processes, each process has a unique PID (process id) and its PPID (parent process id).
Each process only has one parent process, but may have one or more children processes. 
This is just like a tree structure. Only one process has PPID that is 0, which means this process has no parent process. 
All the PIDs will be distinct positive integers.
We use two list of integers to represent a list of processes, 
where the first list contains PID for each process and the second list contains the corresponding PPID.
Now given the two lists, and a PID representing a process you want to kill, 
return a list of PIDs of processes that will be killed in the end. You should assume that when a process is killed, 
all its children processes will be killed. No order is required for the final answer.
Example 1:
Input: 
pid =  [1, 3, 10, 5]
ppid = [3, 0, 5, 3]
kill = 5
Output: [5,10]
Explanation: 
           3
         /   \
        1     5
             /
            10
Kill 5 will also kill 10.
Note:
The given kill id is guaranteed to be one of the given PIDs.
n >= 1.
树的边里，采用深度或者广度
*/

// 此题主要构造hm, val to Node (val, List<Node> children)
// 然后深度搜索所有kill 的孩子们。

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node {
	int id;
	List<Node> children;
	Node(int id) {
		this.id = id;
		this.children = new ArrayList<>();
	}
}
public class KillProcess {
	public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
		Map<Integer, Node> map = new HashMap<>();
		for (Integer i : pid) {
			map.put(i, new Node(i));
		}
		for (int i = 0; i < ppid.size(); i++) {
			if (ppid.get(i) != 0) {
				map.get(ppid.get(i)).children.add(map.get(pid.get(i)));		// 之前加入了node, 所以children直接加进去
			}
		}
		List<Integer> res = new ArrayList<>();
		dfs(map.get(kill), res);
		return res;
	}
	public void dfs(Node node, List<Integer> res) {
		if (node == null)
			return;
		res.add(node.id);
		for (Node n : node.children) {
			dfs(n, res);
		}
	}
}
