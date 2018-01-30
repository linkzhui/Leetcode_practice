package Google.Line.leetcode_268_missing_number;

public class Solution {
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        int[] array = {0,1,2,3,5,6};
        System.out.println(sol.solution_2(array));
    }
    public int solution_1(int[] nums){
        //use math

        int n = nums.length;
        int real_sum = (1+nums[n-1])*(nums[n-1])/2;
        int temp_sum = 0;
        for(int i =0;i<nums.length;i++)
        {
            temp_sum+=nums[i];
        }
        return(real_sum-temp_sum);
    }
    public int solution_2(int[] nums)
    {
        //use XOR
        // 7 XOR 7 = 0
        //0 XOR num = num
        int temp = nums[0]^0;
        int i = 1;
        for(;i<nums.length;i++)
        {
            temp = temp^nums[i]^i;
        }

        return temp^i;

    }
}
