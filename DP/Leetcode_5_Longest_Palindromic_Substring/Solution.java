package Google.DP.Leetcode_5_Longest_Palindromic_Substring;

//corner case: s: 1. "a",  2. ""

public class Solution {
    public String longestPalindrome(String s) {
        if(s==null || s.length()==0)
        {
            return "";
        }
        boolean[][] valid = new boolean[s.length()][s.length()];
        String result = "";
        for(int i = 0;i<s.length();i++)
        {
            char cur = s.charAt(i);
            for(int j = i;j>=0;j--)
            {
                //这里让j = i起步，把valid【i】【i】 = true的情况给包括
                valid[i][j] = (cur == s.charAt(j) && (i-j<=2 || valid[i-1][j+1]));
                if(valid[i][j] && i-j+1>result.length())
                {
                    result = s.substring(j,i+1);
                }
            }
        }
        return result;
    }
}
