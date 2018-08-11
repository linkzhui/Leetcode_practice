package Google.DP.Largest_sum_submatrix;

//Question: Given a matrix of integers (postive & negative numbers & 0s), how to find the submatrix with the largest sum?
public class Solution {
    int largest_sum_method_1(int[][] matrix)
    {
        //the time complex for this method is O(n^4),
        //先通过prefix sun来算出以【0】【0】为左上角，【ℹ】【j】为右下角的submatrix的sum，然后通过枚举法算小长方形的方法算出
        //算出所有的长方形的sum

        int row_number = matrix.length;
        int col_number = matrix[0].length;
        int[][] dp = new int[row_number][col_number];
        int max = 0;
        for(int i = 0;i<row_number;i++)
        {
            //i 是row
            //pre-processing of the matrix[i][j], get the sub_sum of the matrix which the matrix top left corner is 0, and the right bottom corner is [i][j]
            for(int j = 0;j<col_number;j++)
            {
                //j是col
                if(i==0 && j == 0)
                {
                    dp[0][0] = matrix[0][0];
                }
                else if(i == 0)
                {
                    dp[i][j] = dp[i][j-1]+matrix[i][j];
                }
                else if(j==0)
                {
                    dp[i][j] = dp[i-1][j]+matrix[i][j];
                }
                else{
                    dp[i][j] = dp[i-1][j]+dp[i][j-1]+matrix[i][j];
                }
                Math.max(max,dp[i][j]);
            }
        }

        //求一个区域的sub_sum matrix
        //每个小的submatrix
        //     A        B          C
        //     ____________________
        //     |        |          |
        //     | area 1 |   area 2 |
        //   D |-------- --- ------|
        //     | area 3 |   area 4 |
        //   E |-------------------   F

        //area 4 = totoal area - C*D - B*E +B*D
        //通过枚举法算所有的submatrix的值

        for(int out_row_number = 1; out_row_number<row_number;out_row_number++)
        {
            for(int out_col_number = 1;out_col_number<col_number;out_col_number++)
            {
                for(int inner_row_length = 1;inner_row_length<=out_row_number;inner_row_length++)
                {
                    for(int inner_col_length = 1;inner_col_length<=out_col_number;inner_col_length++)
                    {
                        Math.max(max,dp[out_row_number][out_col_number]-dp[inner_row_length-1][out_col_number]-dp[out_row_number][inner_col_length-1]+dp[inner_row_length-1][inner_col_length-1]);
                    }
                }
            }
        }
        return max;
    }

    int largest_submatrix_sum_method_2(int[][] matrix)
    {
        int row_number = matrix.length;
        int col_number = matrix[0].length;
        int[][] dp = new int[row_number][col_number];
        for(int i = 0;i<col_number;i++)
        {
            for(int j = 0;j<row_number;j++)
            {
                if(j == 0)
                {
                    dp[j][i] = matrix[j][i];
                }

                else{
                    dp[j][i] = dp[j-1][i]+matrix[j][i];
                }
            }
        }

        //通过prefix_sum来求出每条横着的row的pre_fix sum
        //然后通过压缩（改变row的number，改变上边界和下边界的值）来算出每个col的sum
        int max = 0;
        int[] sum = new int[col_number];
        for(int i = 0;i<row_number-1;i++)
        {
            //i 是横线的上边界
            for(int j = i;j<row_number;j++)
            {
                // j是横线的下边界

                for(int x = 0;x<row_number;x++)
                {
                    if(i==j)
                    {
                        sum[x] = dp[i][x];
                    }
                    else{
                        sum[x] = dp[j][x] - dp[i-1][x];
                    }

                }
                int temp_sum = sum[0];
                int count = 0;
                for(int z = 1;z<row_number;z++)
                {
                    if(sum[i]<0)
                    {
                        temp_sum = sum[i];
                        count = 0;
                    }
                    if(sum[i]>=0 && count == 0){
                        temp_sum = sum[i];
                        count++;
                    }
                    else{
                        count++;
                        temp_sum+=sum[i];
                    }
                }
                Math.max(max,temp_sum);
            }

        }

        return max;
    }
}
