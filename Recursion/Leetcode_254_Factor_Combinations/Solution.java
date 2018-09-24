package Google.Recursion.Leetcode_254_Factor_Combinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> getFactors(int n) {
        return helper(1,n);
    }

    private List<List<Integer>> helper(int left, int right)
    {
        List<List<Integer>> result = new LinkedList<>();
        if(left!=1)
        {
            List<Integer> resulta=new LinkedList<>(Arrays.asList(left,right));
            result.add(resulta);
        }
        for(int leftchild = Math.max(left,2);leftchild<=Math.sqrt(right);leftchild++)
        {
            int rightchild = right/leftchild;
            if(right == rightchild*leftchild)
            {
                List<List<Integer>> resultchild = helper(leftchild,rightchild);
                if(left!=1)
                {
                    for(List<Integer> resultme:resultchild)
                    {
                        resultme.add(0,left);
                    }
                }
                result.addAll(resultchild);
            }
        }
        return result;
    }
}
