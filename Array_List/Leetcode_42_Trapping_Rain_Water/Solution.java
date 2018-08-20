package Google.Array_List.Leetcode_42_Trapping_Rain_Water;

//对于每一个bar来说，能装水的容量取决于左右两侧bar的最大值。扫描两次，一次从左向右，
// 记录对于每一个bar来说其左侧的bar的最大高度left[i]，一次从右向左，
// 记录每一个bar右侧bar的最大高度right[i]。第三次扫描，则对于每一个bar，
// 计算（1）左侧最大height和当前bar的height的差值（left[i] - heights[i]）
// （2）右侧最大height和当前bar的height的差值（right[i] - heights[i]），取（1），
// （2）中结果小的那个作为当前bar的蓄水量。最终求和得到总蓄水量。

//The water each bar can trap depends on the maximum height on its left and right.
// Thus scan twice - from left to right, and right to left and record the max height in each direction(doesn't include itself height).
// The third time calculate the min difference between left/right height and current bar height.
// Sum the trapped water to get the final result.

public class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int length = height.length;
        int[] left = new int[length];
        int[] right = new int[length];

        left[0] = 0;
        right[length - 1] = 0;
        int trapped_water = 0;
        for (int i = 1; i < length; i++) {
            left[i] = Math.max(height[i - 1], left[i - 1]);
        }

        for (int j = length - 2; j >= 0; j--) {
            right[j] = Math.max(height[j + 1], right[j + 1]);
        }

        for (int k = 0; k < length; k++)
        {
            int water_diff = Math.min(left[k],right[k])-height[k];
            if(water_diff>0)
            {
                trapped_water+=water_diff;
            }
        }

        return trapped_water;

    }
}
