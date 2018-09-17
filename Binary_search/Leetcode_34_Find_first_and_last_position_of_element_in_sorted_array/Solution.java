package Google.Binary_search.Leetcode_34_Find_first_and_last_position_of_element_in_sorted_array;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] array = {0,1,1,1,1,1,2,3,4};
        System.out.println(sol.searchLast(array,1));
    }
    public int searchFirst(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(start+1<end) {
            int mid = (end-start)/2+start;
            if(nums[mid]==target) {
                end = mid;
            } else if(nums[mid]>target) {
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        if(nums[start]!=target && nums[end]!=target) {
            return -1;
        }
        return nums[start]==target? start:end;
    }

    public int searchLast(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(start+1<end) {
            int mid = (end-start)/2+start;
            if(nums[mid]==target) {
                start = mid;
            } else if(nums[mid]>target) {
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        if(nums[start]!=target && nums[end]!=target) {
            return -1;
        }
        return nums[end]==target? end:start;
    }
}
