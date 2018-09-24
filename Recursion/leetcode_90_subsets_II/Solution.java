package Google.Recursion.leetcode_90_subsets_II;

import java.util.ArrayList;
import java.util.List;


//left subtree: normal
//right subtree: if element at current index is duplicated, skip all duplicated current element
public class Solution {
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        int[] nums = {1,2,2};
        List<List<Integer>> result = sol.subsetsWithDup(nums);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0)
        {
            return result;
        }
        dfs(nums,0,new ArrayList<>(),result);
        return result;
    }

    private void dfs(int[] nums, int index, List<Integer> path, List<List<Integer>> result)
    {

        if (index == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        //left subtree: add current element into the path
        path.add(nums[index]);
        dfs(nums, index + 1, path, result);
        path.remove(path.size() - 1);

        //right sub tree: if array[index] is duplicated, we skipping all the current element
        while (index < nums.length - 1 && nums[index + 1] == nums[index]) {
            index++;
        }
        dfs(nums, index + 1, path, result);
    }
}

