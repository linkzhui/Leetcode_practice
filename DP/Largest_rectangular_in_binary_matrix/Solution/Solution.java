package Google.DP.Largest_rectangular_in_binary_matrix.Solution;

//similar idea with find largest sub_sum in submatrix
//time complex: O(n^3)
//space complex: O(n*(n+1)) = O(n^2)
public class Solution {
    int largest_rect_in_binary_matrix(int[][] matrix)
    {
        if(matrix==null || matrix[0].length==0 || matrix.length==0)
        {
            return -1;
        }

        //dp represent the prefix_sum of the column of the matrix

        int row_number = matrix.length;
        int col_number = matrix[0].length;
        int[][] dp = new int[row_number][col_number];
        for(int i =0;i< matrix[0].length;i++)
        {
            for(int j = 0;j<matrix.length;j++)
            {
                dp[j][i] = j==0? dp[j-1][i]+matrix[j][i]:matrix[j][i];
            }
        }

        int[] sum = new int[row_number];
        int max = 0;
        for(int i = 0;i<row_number-1;i++)
        {
            for(int j = i;j<row_number;j++)
            {
                for(int x = 0;x<col_number;x++)
                {
                    if(j==i)
                    {
                        sum[x] = dp[i][x];
                    }
                    else{
                        sum[x] = dp[j][x] - dp[i-1][x];
                    }


                }
                int count = 1;
                for(int z = 1;z<row_number;z++)
                {
                    if(sum[z]==sum[z-1])
                    {
                        count++;
                    }
                    else{
                        count=1;
                    }
                }
                Math.max(max,count*(j-i+1));
            }
        }

        return max;
    }
}
