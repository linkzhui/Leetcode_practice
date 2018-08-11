package Google.String.Leetcode_146_Generate_Parentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        List<String> result = sol.generateParenthesis(3);
    }
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        List<String> result = new ArrayList<>();
        helper(0,0,n,result,sb);
        return result;
    }

    private void helper(int left, int right, int n, List<String> result, StringBuilder sb)
    {
        if(left==right && left == n)
        {
            result.add(sb.toString());
            return;
        }

        if(left<n)
        {
            sb.append('(');
            helper(left+1,right,n,result,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if(right<left)
        {
            sb.append(')');
            helper(left,right+1,n,result,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
