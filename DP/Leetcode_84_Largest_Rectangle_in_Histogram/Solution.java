package Google.DP.Leetcode_84_Largest_Rectangle_in_Histogram;

//直方图中找到最大的矩形

//Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
//For example,
//Given heights = [2,1,5,6,2,3],
//        return 10.



//细节：
// 1. when popped an element from a stack, the left border of this element  = index of element in the top of the stack + 1,
// the right border of this element is cur_index
//2. when stack is empty, the length will be cur_index
//3. 当跑完了整个数组，如果stack还不是空的化，就把right border设置成array.length, 当stack为空的时候，length就是array.length

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public static void main(String[] args) {
        int[] heights = {4,2,0,3,2,5};
        Solution sol = new Solution();
        System.out.println(sol.find_max(heights));
    }

    int find_max(int[] array) {
        Deque<element> stack = new ArrayDeque<>();
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (stack.isEmpty() || stack.peekLast().val <= array[i]) {
                stack.offerLast(new element(i, array[i]));
            } else{
                while (!stack.isEmpty() && stack.peekLast().val > array[i]) {
                    element temp = stack.pollLast();
                    int temp_result = temp.val * (stack.isEmpty()? i:(i - stack.peekLast().index-1));
                    max =Math.max(temp_result, max);
                }
                stack.offerLast(new element(i, array[i]));
            }
        }
        int right_border = array.length;
        while (!stack.isEmpty())
        {
            element temp = stack.pollLast();
            int temp_result = temp.val * (stack.isEmpty()? right_border:(right_border - stack.peekLast().index-1));
            max = Math.max(temp_result, max);
        }
        return max;
    }

    private class element {
        int index;
        int val;

        public element(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }
}