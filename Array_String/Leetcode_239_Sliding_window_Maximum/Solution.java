package Google.Array_String.Leetcode_239_Sliding_window_Maximum;

import java.util.ArrayDeque;
import java.util.Deque;


//通过deque来记录之前的element， deque first element is max element in current window
//case 1: 如果进来一个元素，比deque最后进来的元素还要大，就表示deque比当前这个元素要小的之前都不可能是max，所以linear scan 回头看，来pop出来dq最后的，比现在元素要小的元素
//case 2: 如果dq.first 的元素已经不在当前sliding windows的有效window里面，就把这个dq first element pop out
//    push the current element into the deque
//case 3: if the current index + 1 >= k, then deque first element is max element in current window
public class Solution {
    public static void main (String[] args) {
        Solution sol = new Solution();
        int[] array = {1,3,-1,-3,5,3,6,7};
        System.out.print(sol.maxSlidingWindow(array,3).length);
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length) {
            return null;
        }
        int[] max = new int[nums.length - k + 1];
        int index = 0;
        //Integer represent the index in the array
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if(!dq.isEmpty() && dq.peekFirst() + k == i) {
                dq.pollFirst();
            }
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }
            dq.offerLast(i);
            if (i >= k -1) {
                max[index++] = nums[dq.peekFirst()];
            }
        }
        return max;
    }
}
