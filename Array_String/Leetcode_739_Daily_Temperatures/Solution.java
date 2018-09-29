package Google.Array_String.Leetcode_739_Daily_Temperatures;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0 ) {
            return null;
        }
        //use stack to record the temperature in the history
        //if we have temperatures[i] > tempertaure in the stack, we can pop out the tempertures below current temperatures in the stack, because we know those temperature cannot be the next higher temperature for the rest temperature in the array
        //   1  2   3   6   3  4  5  7
        //  if we meet i temperature[i] = 6, we know the 4, 5 cannot be the cloest higher temperature for temperature from 1 to 3 (index 0 to i-1)
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peekLast()] <= temperatures[i]) {
                stack.pollLast();
            }
            result[i] = stack.isEmpty()? 0 : stack.peekLast() - i;
            stack.offerLast(i);
        }
        return result;
    }
}
