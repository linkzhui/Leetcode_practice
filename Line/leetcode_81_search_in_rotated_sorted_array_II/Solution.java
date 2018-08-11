package Google.Line.leetcode_81_search_in_rotated_sorted_array_II;

public class Solution {
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        int[] array = {3,1};
        int target = 1;
        System.out.println(sol.search(array,target));
    }
    public boolean search(int[] nums, int target) {
        if(nums==null || nums.length == 0)
        {
            return false;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while(start<=end)
        {
            mid = start + (end-start)/2;
            if(nums[mid] == target)
            {
                return true;
            }
            else if(nums[mid]>nums[start]){
                //the left side is sortted
                if(target<nums[mid] && nums[start]<=target)
                {
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
            else if(nums[mid]<nums[end]){
                //the right side is sortted
                //nums[mid]<nums[start]
                if(nums[mid]<target && target <= nums[end])
                {
                    start = mid+1;
                }
                else{
                    end = mid-1;
                }
            }
            else if(nums[mid] == nums[start]){
                start++;
            }
            else
            {
                //nums[mid] == nums[end]
                end--;
            }
        }
        return false;
    }
}