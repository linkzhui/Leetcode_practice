package Google.Recursion.Leetcode_54_Spiral_Matrix;

//Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
//
//For example,
//Given the following matrix:
//
//[
//[ 1, 2, 3 ],
//[ 4, 5, 6 ],
//[ 7, 8, 9 ]
//]
//You should return [1,2,3,6,9,8,7,4,5].

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public static void main(String[] args)
    {
        Solution sol = new Solution();
        int[][] matrix = {{7},{9},{6}};
        System.out.println(Arrays.toString(sol.spiralOrder(matrix).toArray()));

    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new LinkedList<>();
        if(matrix == null ||  matrix.length == 0)
        {
            return result;
        }
        int rowNum = matrix.length, colNum = matrix[0].length;
        int left = 0, right = colNum - 1, top = 0, bot = rowNum - 1;

        while(result.size()<rowNum*colNum)
        {
            for(int col = left; col <= right; col++)
                result.add(matrix[top][col]);
            top++;
            if(result.size() < rowNum * colNum) {
                for(int row = top; row <= bot; row++)
                    result.add(matrix[row][right]);
                right--;
            }
            if(result.size() < rowNum * colNum) {
                for(int col = right; col >= left; col--)
                    result.add(matrix[bot][col]);
                bot--;
            }
            if(result.size() < rowNum * colNum) {
                for(int row = bot; row >= top; row--)
                    result.add(matrix[row][left]);
                left++;
            }
        }

        return result;
    }
}
