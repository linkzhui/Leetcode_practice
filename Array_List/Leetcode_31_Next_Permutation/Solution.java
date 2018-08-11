package Google.Array_List.Leetcode_31_Next_Permutation;

//1. finding first decreasing element nums[i]>nums[i-1]
//2. mark this index decreasing element index to i,
//3. find right hand side the smallest number just larger than this decreasing element
//4. swap the index
//5. reverse all the element from right hand side of i.


//time complexity: O(n)
//space complexity: O(1)
public class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
