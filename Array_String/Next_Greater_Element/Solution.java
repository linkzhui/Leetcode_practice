package Google.Array_String.Next_Greater_Element;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public static void main (String[] args) {
        Solution sol = new Solution();
        int[] nums = {1,2,3,1,2,3,4};
        int[] result = sol.next_Greater_Element(nums);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    //algorithm: use stack
    //1. push to stack if:
    //   if stack is empty() or current element is samller than top of the stack
    //2. pop of the stack:
    //   current element is bigger than top element in the stack, keep pop out until top stack element is bigger or equal to current element
    public int[] next_Greater_Element (int[] nums) {
        if (nums == null) {
            return null;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty() || nums[stack.peekFirst()] >= nums[i]) {
                stack.offerFirst(i);
            } else {
                while (!stack.isEmpty() && nums[stack.peekFirst()] < nums[i]) {
                    int index = stack.pollFirst();
                    result[index] = nums[i];
                }
                stack.offerFirst(i);
            }
        }
        return result;
    }
}
