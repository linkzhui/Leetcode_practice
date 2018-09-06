package Google.Sort.Leetcode_280_Wiggle_Sort;

//time complexity: O(n)
//space complexity: O(1)
//case 1: if n-1 are already sorted, n-1 <= n, then n should n >= n+1   if (n < n + 1), then we need to swap n and n + 1, cause n + 1 is bigger than n, then n + 1 must biggger than n -1
//case 2: if n-1 are already sorted, n-1>=n, then n should n<= n+1 if (n >= n+1), then we need to swap n and n + 1, cause n is bigger than n+1, then n -1 must bigger than n + 1

public class Solution {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        for (int index = 0; index < nums.length - 1; index++) {
            // 1. if index is even number, the nums[index] should <= nums[index + 1]
            // 2. if the index is odd number, the nums[index] should >= nums[index + 1]
            if ((index % 2 == 0 && nums[index] > nums[index + 1]) || (index % 2 == 1 && nums[index] < nums[index+1])) {
                int temp = nums[index];
                nums[index] = nums[index+1];
                nums[index+1] = temp;
            }
        }
    }
}
