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


//enumerate all the permutations in a generative way, the idea is that, at each position, I specify the element by swapping the values with larger index,
//the value at position 0 can be swap with position 1,2 until reach the last element in the string， after each swap, I will do recursion for the rest of the string
public class Solution {
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        Integer[] array = {1,2,3};
        System.out.println(Arrays.toString(sol.permute(array).toArray()));
    }
    public List<List<Integer>> permute(Integer[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if(nums==null || nums.length == 0)
        {
            return result;
        }
        helper(nums,0,result);
        return result;

    }
    private void helper(Integer[] nums, int cur_index,List<List<Integer>> result)
    {
        if(cur_index==nums.length)
        {
            ArrayList<Integer> part_result = new ArrayList<>(Arrays.asList(nums));
            result.add(part_result);
        }
        for(int i = cur_index;i<nums.length;i++)
        {
            swap(nums,cur_index,i);
            helper(nums,cur_index+1,result);  //注意，这里是cur_index
            swap(nums,cur_index,i);
        }
    }
    private void swap(Integer[] nums, int left, int right)
    {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
