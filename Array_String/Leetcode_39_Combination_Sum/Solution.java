package Google.Array_String.Leetcode_39_Combination_Sum;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(candidates,target,0,0,result,path);
        return result;
    }

    private void helper(int[] candidates, int target, int index, int cur_sum, List<List<Integer>> result, List<Integer> path)
    {
        if(cur_sum>=target)
        {
            if(cur_sum==target)
            {
                result.add(new ArrayList<>(path));
            }
            return;
        }
        for(int i = index;i<candidates.length;i++)
        {
            path.add(candidates[i]);
            helper(candidates,target,i,cur_sum+candidates[i],result,path);
            path.remove(path.size()-1);
        }

    }
}
