package Google.DP.fewest_cuts_for_palindrome_partitioning;


//Question: Given a string, a partitioning of the string is a palindrome partitioning if
//every substring of the partition is a palindrome. For example, "aba |b | bbabb| a| b| aba" is a palindrome （每一个substring都是轴对称）
//partitioning of "ababbbabbababa". Determine the fewest cuts needed for palindrome partitioning of a given string. For example, minimum 3 cuts are needed for
// "ababbbabbababa". The three cuts are "a | babbbab | b | ababa". If a string is palindrome, then minimum 0 cuts are needed.

public class Solution {

    int max_cut_1(String s) {
        //dp solution 1
        //int[] dp: represents the min cut to form a palindrome string from index 0 to i;
        //左大段 + 右小段 （manual check if the substring is palindrome or not）

        //time complexity: O(n^3)
        //space: O(n)
        int[] dp = new int[s.length()];
        for (int i = 0; i < s.length(); i++)
        {
            dp[i] = i;
            if(isPal(s,0,i))
            {
                dp[i] = 0;
                continue;
            }
            for(int j = 1; j<=i;j++)
            {
                if(isPal(s,j,i))
                {
                    dp[i] = Math.min(dp[i],dp[j-1]+1);
                }
            }

        }
        return dp[s.length()-1];
    }

    int max_cut_2(String s)
    {
        //Method 2: 2D DP
        //cut[j] tells: the minimum cut to form a palindrome string from (n-1) to j (include the j);


        //DP[i][j]: represents the substring from index i to j is valid palindrome or not
        //   a    b   c   d
        //1 letter  DP[0][0]
        //2 letter DP[0][1]   DP[1][1]
        //3 letter DP[0][2]   DP[1][2] DP[2][2]
        //4 letter DP[0][3]   DP[1][3]  DP[2][3]   DP[3][3]
        //Y Y Y Y Y
        //X Y Y Y Y
        //X X Y Y Y
        //X X X Y Y
        //X X X X Y
        // in order to fill the [i][j], we need value from [i+1][j-1],
        //we will fill the dp from bottom up and left to right

        //the x represents no values

        if(s==null || s.length()<2)
        {
            return 0;
        }
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int[] cut = new int[n];
        for(int i = n-1;i>=0;i++) {

            //i represents the 左大段和右小段的左边界
            //j represents the 右小段的右边界
            cut[i] = n - 1 - i;

            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1]))
                {
                    dp[i][j] = true;
                    if(j == n-1)
                    {
                        cut[i]=0;
                    }
                    else{
                        cut[i] = Math.min(cut[i],cut[j+1]+1);
                    }
                }
            }
        }

        return cut[0];
    }

    boolean isPal(String s, int left, int right)
    {
        while(left<right)
        {
            if(s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

}
