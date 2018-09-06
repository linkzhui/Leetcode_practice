package Google.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashMap<String, List<Neighboor>> map = new HashMap<>();

        //step 1: construct the graph
        int index = 0;
        for(String[] eqaution : equations) {
            if(map.containsKey(eqaution[0])) {
                map.put(eqaution[0], new ArrayList<>());
            }
            if(map.containsKey(eqaution[1])) {
                map.put(eqaution[1], new ArrayList<>());
            }
            map.get(eqaution[0]).add(new Neighboor(eqaution[1], values[index]));
            map.get(eqaution[1]).add(new Neighboor(eqaution[0],1/values[index]));
            index++;
        }
        index = 0;
        double[] result = new double[queries.length];
        for(String[] query:queries) {
            double dfs_result = dfs(query[0], query[1], map, new HashSet<>(), 1.0);
            if (dfs_result == 0.0)
            {
                dfs_result = -1.0;
            }
            result[index++] = dfs_result;
        }
        return result;
    }

    private double dfs(String start, String end, HashMap<String, List<Neighboor>> map, HashSet<String> set, double result) {
        //corner case 1: map does not contain the start
        //2. set already contain the start
        //3. start == end
        if (!map.containsKey(start) || set.contains(start)) {
            return 0.0;
        } else if (start.equals(end)) {
            return 1.0;
        }
        set.add(start);
        for(Neighboor neighboor:map.get(start)) {
            double temp = dfs(neighboor.node, end, map, set, result * neighboor.value);
            if(temp != 0.0) {
                return temp;
            }
        }
        set.remove(start);
        return 0.0;
    }

    private class Neighboor{
        String node;
        double value;
        private Neighboor(String node, double value) {
            this.node = node;
            this.value = value;
        }
    }
}
