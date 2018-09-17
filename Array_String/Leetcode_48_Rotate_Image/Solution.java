package Google.Array_String.Leetcode_48_Rotate_Image;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        Integer[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        sol.clockWiseRotate(matrix);

    }
    public void clockWiseRotate(Integer[][] matrix) {
        if (matrix == null) {
            return;
        }

        int length = matrix.length;
        //up down reverse
        for (int i = 0; i < length/2; i++) {
            for (int j = 0; j < length; j++) {
                int temp_first = matrix[length-i-1][j];
                matrix[length-i-1][j] = matrix[i][j];
                matrix[i][j] = temp_first;
            }
        }

        //symmetry reverse
        for (int i = 0; i < length; i++)  {
            for (int j = 0; j < length ; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}
