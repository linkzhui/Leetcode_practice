package Google.Math.leetcode_149_Max_Points_On_a_Line;

import java.util.HashMap;

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
//traverse the points array, enumerate all the possible combination of lines that let index i as one point for this lines, and let i+1 -> points.length as other points for the line
//for (int i = 0; i < points.length - 1; i++) {
//     for (int j = i+1; j < points.length; j++) {

//     }
// }

//max[0]: current max number of points lies on the straight line
//we will records all the number of possible slopes, then compare current max number of points in the same slope with our max[0]
//case 1: same points, we need to keep track of same points, because same point can be count as number of points into all the possible slopes
//case 2: vertical line
//case 3: horizontal line

    //time complexity: O(n!)
    //space complexity: O(n)
class Solution {

    private class Point{
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }

    public int maxPoints(Point[] points) {
        if (points.length == 0) {
            return 0;
        } else if (points.length <= 2) {
            return points.length;
        }

        int result = 0;
        for (int i = 0; i < points.length - 1; i++) {
            HashMap<String, Integer> slope_count = new HashMap<>();
            int cur_max = 0;
            int same_point = 1;
            Point p1 = points[i];
            for (int j = i + 1; j < points.length; j++) {
                Point p2 = points[j];
                if(p1.x == p2.x && p1.y == p2.y) {
                    same_point++;
                } else {
                    String slope = getSlope(p1, p2);
                    int count = slope_count.getOrDefault(slope, 0) + 1;
                    slope_count.put(slope, count);
                    cur_max = Math.max(cur_max, count);
                }
            }
            result = Math.max(result, cur_max + same_point);
        }

        return result;
    }

    private String getSlope(Point p1, Point p2) {
        int dx = p1.x - p2.x;
        int dy = p1.y - p2.y;
        //vertival line
        if(dx == 0) {
            return new String(String.valueOf(p1.y)+","+0);
        } else if (dy == 0) {
            return new String(0 + "," + String.valueOf(p1.x));
        }
        //why we need to get gcd, because we need to make slope is unique, therefore we need to remove the greatest common divisor from the dx and dy
        int gcd = gcd(dx, dy);
        return new String(String.valueOf(dy / gcd) + "," + String.valueOf(dx / gcd));
    }

    private int gcd (int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}