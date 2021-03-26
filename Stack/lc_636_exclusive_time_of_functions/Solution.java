package Google.Stack.lc_636_exclusive_time_of_functions;

import java.util.*;

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        int prevTimeStamp = 0;
        int[] result = new int[n];

        for (String log : logs) {
            String[] logArr = log.split(":");
            int funcId = Integer.parseInt(logArr[0]);
            String status = logArr[1];
            int curTimeStamp = Integer.parseInt(logArr[2]);
            if (status.equals("start")) {
                if (!stack.isEmpty()) {
                    result[stack.peek()] += curTimeStamp - prevTimeStamp;
                }
                stack.push(funcId);
                prevTimeStamp = curTimeStamp;
            } else {
                result[stack.pop()] += curTimeStamp - prevTimeStamp + 1;
                prevTimeStamp = curTimeStamp + 1;
            }
        }
        return result;
    }
}