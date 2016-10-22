/*
Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:
If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.
Example 1:
tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
Example 2:
tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.
*/
// 此题要注意，hm中的valuey有可能不在hm中的key中出现（单线飞走了）。所以进行boolean的判断。比如["JFK", "ATL"]["JFK", "SFO"]["SFO" -> "JFK"].

public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        List<String> res = new ArrayList<>();
        if (tickets == null || tickets.length == 0 || tickets[0].length == 0)
            return res;
        HashMap<String, List<String>> hm = new HashMap<>();
        for (String[] ticket : tickets) {
            if (!hm.containsKey(ticket[0]))
                hm.put(ticket[0], new ArrayList<String>());
            hm.get(ticket[0]).add(ticket[1]);  
        }
        for (List<String> list : hm.values()) {
            Collections.sort(list);
        }
        res.add("JFK");
        if(DFS(res, "JFK", hm, tickets.length + 1))
        	return res;
        return res;
    }
	public boolean DFS(List<String> res, String start, HashMap<String, List<String>> hm, int len) {
		if (res.size() == len)
			return true;
		if (!hm.containsKey(start) || hm.get(start) == null)
			return false;
		for (int i = 0; i < hm.get(start).size(); i++) {
			String temp = hm.get(start).get(i);                             
			res.add(temp);                                          // res加进去key对应的每一个value
			hm.get(start).remove(i);                                // 用完则删除
			if (DFS(res, temp, hm, len))
				return true;
			res.remove(res.size() - 1);                             // res删掉不合适的
			hm.get(start).add(i, temp);                             // 删除完的再加回来。
		}
		return false;
	}
}
