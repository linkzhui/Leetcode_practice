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
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        return canPartition(nums, visited, k, 0, 0, sum / k);
    }

    private boolean canPartition(int[] nums, boolean[] visited, int k, int start, int curSum, int target) {
        if (k == 1) {
            return true;
        }
        if (curSum == target) {
            return canPartition(nums, visited, k - 1, 0, 0, target);
        }
        for (int i = start; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (curSum + nums[i] > target) {
                break;
            }
            visited[i] = true;
            if (canPartition(nums, visited, k, i + 1, curSum + nums[i], target)) {
                return true;
            }
            visited[i] = false;
        }
        return false;
    }
}
