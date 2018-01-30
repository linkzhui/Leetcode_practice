package Google.DP.Edit_distance;


//Question: Given two strings of alphanumeric characters, determine the minimum number of replace,
//delete, and insert operations needed to transform one string into the other.

import java.util.Arrays;

//dp[i][j] represents the minimum number of actions to transform substring( the first i letters of s1 to the first j letters of s2)
//solution：
//base case dp[0][0] = 0,dp[0][m] = m, dp[n][0] = n
//induction rule
//case 1: if(words1[i] == word2[j]) we don't need operation dp[i][j] = dp[i-1][j-1];
//case 2: if(words1[i]!=word2[j])
//      a: replace 1+dp[i-1][j-1]
//      b: delete  1+dp[i-1][j-1]
//      c: insert  1+dp[i][j-1]
//      min (case a, case b, case c);
public class Solution {
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        String s1 = "a";
        String s2 = "b";
        System.out.println(sol.minDistance(s1,s2));
    }
    public int minDistance(String word1, String word2) {
        if(word1 == null && word2 == null)
        {
            return 0;
        }
        if(word1 == null || word2 == null || word1.length() == 0 || word2.length() == 0)
        {
            return word1 == null || word1.length()==0? word2.length():word1.length();
        }

        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int i = 0;i<=word2.length();i++)
        {
            dp[0][i] = i;
        }

        for(int i = 0;i<=word1.length();i++)
        {
            dp[i][0] = i;
        }

        int i;
        int j;
        for(i=1;i<=word1.length();i++)
        {
            for(j = 1;j<=word2.length();j++)
            {
                int distance = Math.min(Math.min(dp[i-1][j-1]+1,dp[i-1][j]+1),dp[i][j-1]+1);
                if(word1.charAt(i-1)!=word2.charAt(j-1))
                {
                    dp[i][j] = distance;
                }

                else{
                    dp[i][j] = dp[i-1][j-1];
                }
            }

        }
        return dp[word1.length()][word2.length()];
    }
}
