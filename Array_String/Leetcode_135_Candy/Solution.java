package Google.Array_String.Leetcode_135_Candy;

//Solution 1: use one extra array, to scan the ratings from left to right, then scan right to left again

//Solution 2 (best): use slope to determine the candies number

public class Solution {

    //Solution 1:
    //time complexity: O(n)
    //space complexity: O(n)

    //创建一个int[] candies来记录每个人需要给多少个candy,
    //把ratings从左到右扫描一遍，如果生序就candies[i] = candies[i-1]+1,降序或者相同的rating就candies[i] = 1;
    //然后从右往左再扫描一遍,用一个temp value来记录右边neighboor的value, 如果生序就current candy = temp_value+1，降序就1
    //然后candies[i] = Math.max(candies[i], current candy)
    public int candy_1(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        int length = ratings.length;
        int[] candies = new int[length];
        candies[0] = 1;
        for (int i = 1; i < length; i++) {
            if (ratings[i] > ratings[i-1]) {
                candies[i] = candies[i-1] + 1;
            }
            else {
                candies[i] = 1;
            }
        }

        int max = candies[length - 1];
        int prev = 1;
        for (int i = length - 2; i>=0; i--) {
            if (ratings[i] > ratings[i+1]) {
                prev += 1;
            } else {
                prev = 1;
            }
            max += Math.max(prev, candies[i]);
        }
        return max;
    }


    //*****************Solution 2**********************

    public int count(int n) {
        return (n * (n + 1)) / 2;
    }

    public int candy_2(int[] ratings) {
        if (ratings.length <= 1) {
            return ratings.length;
        }
        int candies = 0;
        int up = 0;
        int down = 0;
        int old_slope = 0;
        for (int i = 1; i < ratings.length; i++) {
            int cur_slope = (ratings[i] > ratings[i - 1]) ? 1 : (ratings[i] < ratings[i - 1] ? -1 : 0);
            if ((old_slope > 0 && cur_slope == 0) || (old_slope < 0 && cur_slope >= 0)) {
                //如果发现一个小孩的rating和pre的rating一样,那么第二个rating就是新的开始的点
                candies += count(up) + count(down) + Math.max(up, down);
                up = 0;
                down = 0;
            }
            if (cur_slope > 0)
                up++;
            if (cur_slope < 0)
                down++;
            if (cur_slope == 0)
                candies++;

            old_slope = cur_slope;
        }
        candies += count(up) + count(down) + Math.max(up, down) + 1;
        return candies;
    }

    public int candy(int[] ratings) {
        if (ratings == null || ratings.length ==0) {
            return 0;
        }
        int up = 0;
        int down = 0;
        int candy = 1;
        int old_slope = 0;
        for (int i = 1; i < ratings.length; i++) {
            int cur_slope = ratings[i] > ratings[i-1]? 1 : (ratings[i] < ratings[i-1]? -1 : 0);
            if ((cur_slope == 0 && old_slope == 1) || (cur_slope >= 0 && old_slope < 0)) {
                candy += count(up) + count(down) + Math.max(up, down);
                up = 0;
                down = 0;
            }
            if (cur_slope > 0) {
                up++;
            }
            else if (cur_slope < 0) {
                down++;
            } else {
                candy++;
            }
            old_slope = cur_slope;
        }
        candy += count(up) + count(down) + Math.max(up,down);
        return candy;
    }
}
