package Google.Line.leetcode_33_search_in_rotated_sorted_array;

//Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//
//        (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//
//        You are given a target value to search. If found in the array return its index, otherwise return -1.
//
//        You may assume no duplicate exists in the array.


//先判定反转的点在左边还是右边

public class Solution {
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        int[] array = {1,3};
        int target = 3;
        System.out.println(sol.search(array,target));
    }
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int mid;
        while(start<=end)
        {
            mid = start + (end - start)/2;
            if(nums[mid] == target)
            {
                return mid;
            }
            else if(nums[start] <= nums[mid]) {
                if (target >= nums[start] && target < nums[mid])
                {
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }
            else
            {
                if(target>nums[mid] && target<=nums[end])
                {
                    start = mid+1;
                }
                else{
                    end = mid-1;
                }
            }
        }
        return -1;
    }
}
