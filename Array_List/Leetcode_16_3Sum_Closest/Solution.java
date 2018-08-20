package Google.Array_List.Leetcode_16_3Sum_Closest;


import java.util.Arrays;

//two pointers:use for loop tp iterator the array,然后选择这个点的i+1的点作为left，然后array的终点作为right, we keep moving those two pointers to find target solution,
// when left and right meet up, we terminate the while loop, and move the current point to the right by 1.
public class Solution {
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        int[] array = {0,1,2};
        System.out.print(sol.threeSumClosest(array,3));
    }
    public int threeSumClosest(int[] nums, int target) {
        int length = nums.length;
        int result = nums[length-1]+nums[length-2]+nums[length-3];
        Arrays.sort(nums);
        for(int i = 0;i<nums.length-2;i++)
        {
            int left = i+1;
            int right = length-1;
            while(left<right)
            {
                int sum_result = nums[i]+nums[left]+nums[right];
                if(sum_result>=target)
                {
                    right--;
                }
                else
                {
                    left++;
                }
                result = Math.abs(result-target)>Math.abs(sum_result-target)? sum_result:result;
            }
        }
        return result;
    }
}
