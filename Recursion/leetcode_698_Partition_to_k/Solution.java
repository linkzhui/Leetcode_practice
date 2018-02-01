package Google.Recursion.leetcode_698_Partition_to_k;

import java.util.Arrays;

//not finish yet
public class Solution {
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        int[] nums = {4,3,2,3,5,2,1};
        int k = 4;
        System.out.print(sol.canPartitionKSubsets(nums,k));
    }
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(Integer element:nums)
        {
            sum+=element;
        }

        if(nums==null||nums.length==0||k<=0||sum%k!=0)
        {
            return false;
        }
        sum/=k;
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length-1;
        int count=0;
        return helper(nums,k,sum,0,0,nums.length-1);
    }

    private boolean helper(int[] nums, int k, int sum, int cur_sum, int start, int end)
    {
        if(k==0&&start>end)
        {
            return true;
        }

        if(cur_sum>sum||start>end||k<0)
        {
            return false;
        }

        if(cur_sum==sum)
        {
            k--;
            cur_sum=0;
            if(helper(nums,k,sum,cur_sum,start,end)){
                return true;
            }
        }

        if(helper(nums,k,sum,cur_sum+nums[start],start+1,end)){
            return true;
        }

        if(helper(nums,k,sum,cur_sum+nums[end],start,end-1))
        {
            return true;
        }

        return false;

    }
}
