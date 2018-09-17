package Google.Array_String.Leetcode_287_3Sum;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Assumption: is array sorted or not?
//time complexity: O(n^2)
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums==null || nums.length<3)
        {
            return result;
        }
        Arrays.sort(nums);
        for(int i = 0;i<nums.length-2;i++)
        {
            int start = i+1;
            int end = nums.length-1;
            while (start<end)
            {
                if(nums[i]+nums[start]+nums[end]==0)
                {
                    Integer[] part_result = {nums[i],nums[start],nums[end]};
                    result.add(Arrays.asList(part_result));
                    while(start<end && nums[start] == nums[start+1])
                    {
                        start++;
                    }
                    while(start<end && nums[end]==nums[end-1])
                    {
                        end--;
                    }
                    start++;
                    end--;
                }
                else if(nums[start]+nums[end]+nums[i]<0)
                {
                    start++;
                }
                else{
                    end--;
                }
            }
        }
        return result;
    }
}
