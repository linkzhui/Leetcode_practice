package Google.Recursion.leetcode_46_permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//Given a collection of distinct numbers, return all possible permutations.
//
//        For example,
//        [1,2,3] have the following permutations:
//        [
//        [1,2,3],
//        [1,3,2],
//        [2,1,3],
//        [2,3,1],
//        [3,1,2],
//        [3,2,1]
//        ]
public class Solution {
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        int[] array = {1,2,3};
        System.out.println(Arrays.toString(sol.permute(array).toArray()));
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if(nums==null || nums.length == 0)
        {
            return result;
        }
        helper(nums,0,result);
        return result;

    }
    private void helper(int[] nums, int cur_index,List<List<Integer>> result)
    {
        if(cur_index==nums.length)
        {
            ArrayList<Integer> part_result = new ArrayList<>();
            for(int element:nums){
                part_result.add(element);
            }
            result.add(part_result);
        }
        for(int i = cur_index;i<nums.length;i++)
        {
            swap(nums,cur_index,i);
            helper(nums,cur_index+1,result);
            swap(nums,cur_index,i);
        }
    }
    private void swap(int[] nums, int left, int right)
    {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
