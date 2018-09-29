package Google.Array_String.Leetcode_163_Missing_Ranges;

import java.util.ArrayList;
import java.util.List;


//Assumption:
//sorted-> ascending, descending
//duplicated element in the array


//corner case 1: if nums array is empty or null, return lower -> upper
//corner case 2: if the int lower is min integer and upper is max integer
                //we need to convert the int to long for lower and upper


//keep check nums[i] -> nums[i-1] to find out is there any missing ranges

//how to find missing ranges:
// case 1: right - left <= 1, return null, no missing ranges
// case 2: right - left == 2, return left + 1, only one missing number
// case 3: return left + 1 -> right - 1

//two cases, we need to check the first element in the nums with lower and last element in the array with upper
//case 1: check first element in the nums with lower
        //if i == 0 -> left = lower - 1,right  = nums[i]
//case 2: check last element in the nums with upper
        //if i == nums.length -> left = nums[nums.length - 1], right = upper + 1;


public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            String range = helper((long)lower - 1, (long)upper + 1);
            result.add(range);
            return result;
        }

        for(int i = 0; i <= nums.length; i++) {
            long left, right;
            if (i == 0) {
                //if i is 0, then we need check the lower
                left = (long) lower - 1;
                right = nums[i];
            }  else if (i == nums.length) {
                //if is the length of the nums.length, we need to check upper
                left = nums[i-1];
                right = (long) upper + 1;
            } else {
                left = nums[i-1];
                right = nums[i];
            }
            String cur_range = helper (left, right);
            if (cur_range != null) {
                result.add(cur_range);
            }
        }

        return result;
    }

    private String helper (long left, long right) {
        if (right - left <= 1) {
            return null;
        } else if (right - left == 2) {
            return String.valueOf(left+1);
        } else {
            return String.valueOf(left + 1) + "->" + String.valueOf(right - 1);
        }
    }
}
