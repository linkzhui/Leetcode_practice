package Google.Recursion.leetcode_90_subsets_II;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        int[] nums = {2,2};
        List<List<Integer>> result = sol.subsetsWithDup(nums);

    }    public List<List<Integer>> subsetsWithDup(int[] nums){
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
        result.add(new ArrayList<>(path));

        for(int i = index;i<nums.length;i++)
        {
            if(i>index && nums[i] == nums[i-1])
            {
                continue;
            }
            path.add(nums[i]);
            dfs(nums,i+1,path,result);
            path.remove(path.size()-1);
        }
    }
}

