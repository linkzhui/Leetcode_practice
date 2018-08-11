package Google.Line.leetcode_356_line_reflection;

//Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given points.
//
//Example 1:
//Given points = [[1,1],[-1,1]], return true.
//
//Example 2:
//Given points = [[1,1],[-1,-1]], return false.
//
//Follow up:
//Could you do better than O(n2)?

import java.util.Arrays;
import java.util.HashSet;

public class Solution {

    public boolean isReflected(int[][] points) {
        //iterate all the array to find the min point and max point, to find the mid point of the line that parallel to y-axis that reflect the given points
        if(points == null || points.length==0||points[0].length!=2)
        {
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int[] point:points)
        {
            min = point[0]<min? point[0]:min;
            max = point[0]>max? point[0]:max;
            set.add(Arrays.hashCode(point));
        }
        int sum = max+min;
        for(int[] point:points)
        {
            if(!set.contains(Arrays.hashCode(new int[]{sum-point[0],point[1]})))
            {
                return false;
            }
        }
        return true;
    }
}
