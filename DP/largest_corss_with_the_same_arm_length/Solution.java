package Google.DP.largest_corss_with_the_same_arm_length;

//Question: Given a matrix that contains only 1's and 0s
//how to find the largest cross with the same arm lengths
//and the two arms join at the central point of each others.

public class Solution {
    public int largest_cross(int[][] array)
    {
        if (array == null || array[0].length == 0 || array.length == 0) {
            return 0;
        }

        int max = 0;
        int[][] dp_1 = new int[array.length][array[0].length];
        int[][] dp_2 = new int[array.length][array[0].length];
        int[][] dp_3 = new int[array.length][array[0].length];
        int[][] dp_4 = new int[array.length][array[0].length];

        for(int i = 0;i<array[0].length;i++)
        {
            for(int j = 0;j<array.length;j++)
            {

            }
        }

        return max;
    }
}
