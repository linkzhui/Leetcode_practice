package Google.DP.leetcode_446_arithmetic_slices_II;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args)
    {
        Solution sol  = new Solution();
        int[] a = {1,2,3,4,5,6};
        int result = sol.numberOfArithmeticSlices(a);
        System.out.println(result);
    }
    public int numberOfArithmeticSlices(int[] A) {
        int sum = 0;
        int[][] dp = new int[A.length][A.length];
        for(int i = 2;i<A.length;i++)
        {
            for(int z = 1;i-z*2>=0;z++)
            {
                if(i-z*2>=0 && A[i]-A[i-z]==A[i-z]-A[i-z*2])
                {
                    dp[i][z] = dp[i-z][z]+1;
                    sum+=dp[i][z];
                }
            }

        }
        return sum;
    }
}
