package Google.Graph.Leetcode_332_Reconstruct_Itineray;

import java.util.*;

public class Solution {
    //1. 把input转换为图的结构:给定一个点，能快速地知道它所连接的邻居点们，并且以lexical order的顺序访问它们。 (HashMap<String, List<String>>)
    //2. 在构造的图上从JFK开始做DFS, remove掉访问过的边，backtrack时候再加回来

    //time complexity: O(n) + O(nlogn) +O(n!)  create graph+sort the arrive city + dfs
    //space complexity: O(n)
    public List<String> findItinerary(String[][] tickets) {
        if (tickets == null || tickets.length == 0) {
            return null;
        }

        int totalLen = tickets.length + 1;

        Map<String, List<String>> map = new HashMap<>();  //key is departure city, list<String> arrive cities
        for (String[] ticket : tickets) {
            if (!map.containsKey(ticket[0])) {
                map.put(ticket[0], new ArrayList<>());
            }
            map.get(ticket[0]).add(ticket[1]);
        }

        //Sort the list according to the lexical order
        for (List<String> list : map.values()) {
            Collections.sort(list);
        }
        List<String> result = new ArrayList<>();
        result.add("JFK");
        if (findItineary("JFK", result, map, totalLen)) {
            return result;
        }

        return null;
    }

    private boolean findItineary(String start, List<String> path, Map<String, List<String>> map, int totalLen) {
        if (path.size() == totalLen) {
            return true;
        }

        if (!map.containsKey(start)) {
            return false;
        }

        List<String> destinations = map.get(start);

        for (int i = 0; i < destinations.size(); i++) {
            String dest = destinations.get(i);
            path.add(dest);
            destinations.remove(i);
            if (findItineary(dest, path, map, totalLen)) {
                return true;
            }
            path.remove(path.size()-1);
            destinations.add(i, dest);
        }
        return false;
    }
}
