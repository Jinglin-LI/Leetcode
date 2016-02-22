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

public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        List<String> res = new ArrayList<>();
        HashMap<String, List<String>> hm = new HashMap<>();
        for (String[] t : tickets) {
            if (!hm.containsKey(t[0]))
                hm.put(t[0], new ArrayList<String>());
            hm.get(t[0]).add(t[1]);
        }
        for (List<String> list : hm.values()) {
            Collections.sort(list);
        }
        if (DFS(res, hm, "JFK", tickets.length + 1))                      // tickets are all used up. It is an itinerary.
            return res;
        return res;
    }
    private boolean DFS(List<String> res, HashMap<String, List<String>> hm, String start, int len) {
        res.add(start);
        if (res.size() == len)
            return true;
        if (!hm.containsKey(start) || hm.get(start).isEmpty())
            return false;
        
        for (int i = 0; i < hm.get(start).size(); i++) {                  // need remove and add the string in the same index. 
                String newDest = hm.get(start).remove(i);                 // remove the destination in the hm

                if (DFS(res, hm, newDest, len))
                    return true;
                
                res.remove(res.size() - 1);                               // remove the destination in the res
                hm.get(start).add(i, newDest);                            // add the destination in the hm at the previous index
        }
        return false;
    } 
}
