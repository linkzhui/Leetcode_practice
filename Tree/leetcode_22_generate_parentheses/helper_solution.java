package Google.Tree.leetcode_22_generate_parentheses;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by raymon on 6/25/17.
 */

public class helper_solution {
    public List<String> generateParenthesis(int n){
        if(n==0)
        {
            return (new LinkedList<>());
        }
        return helper(1,0,'(',n);
    }
    private List<String> helper(int left, int right, char c, int n){
        //base case
        List<String> result = new LinkedList<>();
        if(right==left &&left==n)
        {
            result.add(String.valueOf(c));
            return result;
        }
        //traverse the tree
        if(left<n)
        {
            List<String> childresult = helper(left+1,right,'(',n);
            for(String part_result:childresult)
            {
                result.add(c+part_result);
            }

        }
        if(right<left)
        {

            List<String> childresult = helper(left,right+1,')',n);
            for(String part_result:childresult)
            {
                result.add(c+part_result);
            }
        }
        return result;
    }
}

