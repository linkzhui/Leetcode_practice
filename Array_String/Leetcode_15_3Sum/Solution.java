package Google.Array_String.Leetcode_15_3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if ( nums == null || nums.length < 3) {
            return result;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int low = i + 1;
            int high = nums.length - 1;
            int num = nums[i];
            while(low < high) {
                if (num + nums[low] + nums[high] == 0) {
                    Integer[] part_result = {num, nums[low], nums[high]};
                    result.add(new ArrayList<>(Arrays.asList(part_result)));

                    //remove the duplicate result from the array
                    while (low < high && nums[low] == nums[low + 1]) {
                        low++;
                    }
                    while (high > low && nums[high] == nums[high - 1]) {
                        high--;
                    }

                    low++;
                    high--;
                }
                else if(num + nums[low] + nums[high] > 0){
                    high--;
                }
                else{
                    low++;
                }
            }
        }
        return result;
    }
}