package Google.DP.Leetcode_55_Jump_Game;

public class Solution {
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        int[] array = {2,3,1,1,4};
        System.out.println(sol.canJump(array));

    }
    public boolean canJump(int[] nums) {
        boolean[] bool_array = new boolean[nums.length+1];
        bool_array[nums.length] = true;
        for(int i = nums.length -1;i>=0;i--)
        {
            for(int j = 0;j<=nums[i];j++)
            {
                if(bool_array[i+j])
                {
                    bool_array[i] = true;
                    break;
                }
            }
        }
        return bool_array[0];
    }
}
