package Google.Line.leetcode_84_largest_rectangle_in_histogram;

//Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

//Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
//
//
//        The largest rectangle is shown in the shaded area, which has area = 10 unit.
//
//        For example,
//        Given heights = [2,1,5,6,2,3],
//        return 10.


import Google.data_structure.Queue.implement_a_dequeue_with_multiple_stack.Dequeue;

import java.util.ArrayDeque;
import java.util.Deque;

//solution1: 中心开花，从中间往两遍找，直到找到一个比自己低的边界为止，time complexity: O(n^2)
//solution2: stack
//如果是升序的话，我就直到自己的左边界肯定就是我自己，如果碰到降序，我看自己是不是比降序的这个
public class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 1; i < heights.length; i++) {

        }

        return 0;

    }

    private class element{
        int val;
        int index;
        public element(int val, int index)
        {
            this.val = val;
            this.index = index;
        }
    }
}
