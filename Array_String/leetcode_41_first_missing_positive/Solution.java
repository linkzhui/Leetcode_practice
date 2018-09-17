package Google.Line.leetcode_41_first_missing_positive;

class Solution {
    public static void main(String[] args)
    {
        int[] array = {1,2,4};
        Solution sol = new Solution();
        System.out.println(sol.firstMissingPositive(array));
    }
    public int firstMissingPositive(int[] nums) {
        int start = -1;
        for(int i = 0;i<nums.length;i++)
        {
            if(nums[i]<=0)
            {
                swap(++start,i,nums);
            }
        }
        if(start==nums.length-1)
        {
            return 1;
        }
        start++;
        for(int j = start;j<nums.length;j++)
        {
            int index = Math.abs(nums[j]);
            if(index+start-1<nums.length)
            {
                nums[index+start-1] = Math.abs(nums[index+start-1])*-1;
            }

        }
        int first_missing = start;
        for(;first_missing<nums.length;first_missing++)
        {
            if(nums[first_missing]>0)
            {
                break;
            }
        }
        return first_missing - start+1;
    }

    private void swap(int left, int right,int[] nums)
    {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
