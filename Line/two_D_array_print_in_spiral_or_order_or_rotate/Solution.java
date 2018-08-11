package Google.Line.two_D_array_print_in_spiral_or_order_or_rotate;

import java.util.Arrays;
import java.util.List;

//Question 3.1: how to print 2D array in spiral order (N*N)
//1     2   3   4   5
//16    17  18  19  6
//15    24  25  20  7
//14    23  22  21  8
//13    12  11  10  9
public class Solution {

    public static void main(String[] args)
    {
        Solution sol =new Solution();
        int target = 5;
        int[][] result = new int[target][target];
        sol.spiral(0,target,result,0);
        for(int i = 0;i<target;i++)
        {
            System.out.println(Arrays.toString(result[i]));
        }

    }
    void spiral(int n,int target, int[][] result,int cur_value)
    {
        int col = n;
        int row =n;
        if(n>=target/2)
        {
            if(target%2!=0)
            {
                result[n][n] = ++cur_value;
            }

            return;
        }


        for(int i = 0;i<target-n*2-1;i++)
        {
            //top: left to right
            result[row][col++] = ++cur_value;
        }

        for(int i =0;i<target-n*2-1;i++)
        {
            //right: top to bottom
            result[row++][col] = ++cur_value;
        }
        for(int i =0;i<target-n*2-1;i++)
        {
            //bottom: right to left
            result[row][col--] = ++cur_value;
        }
        for(int i =0;i<target-n*2-1;i++)
        {
            //left : bottom to top
            result[row--][col] = ++cur_value;
        }
        spiral(n+1,target,result,cur_value);

    }
}
