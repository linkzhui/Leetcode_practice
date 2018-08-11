package Google.DP.Largest_square_in_binary_matrix;

public class Solution {

    public static void main(String[] args)
    {
        Solution sol = new Solution();
        int[][] array = {{0,0,0,0,0},{1,1,1,1,0},{1,1,1,1,0},{1,1,1,0,0},{1,1,1,0,0}};
        System.out.println(sol.lar_sq(array));
    }

    public int lar_sq(int[][] array) {

        //DP[j][i] represent the max size of the square as coordinated[j][i] as the
        //right corner of the square
        if (array == null || array[0].length == 0 || array.length == 0) {
            return 0;
        }

        int[][] dp = new int[array[0].length][array.length];

        //copy the first row and column of the array's elements into the dp.
        for (int i = 0; i < array[0].length; i++) {
            dp[0][i] = array[0][i];
        }

        for (int j = 0; j < array.length; j++)
        {
            dp[j][0] = array[j][0];

        }
        int max = 0;
        for(int i = 1; i<array[0].length;i++)
        {
            //i represent the column of the array

            for(int j = 1;j<array.length;j++)
            {
                //j represent the horizontal of the array
                if(array[j][i]==0)
                {
                    dp[j][i] = 0;
                }
                else{
                    //the array[j][i] = 1
                    dp[j][i] = 1+Math.min(Math.min(dp[j-1][i],dp[j][i-1]),dp[j-1][i-1]);
                    max = dp[j][i]>max? dp[j][i]:max;
                }
            }
        }
        return max;
    }
}
