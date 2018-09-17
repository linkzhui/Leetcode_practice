package Google.Array_String.Leetcode_128_Longest_Consecutive_Sequence;

import java.util.HashSet;


//approach: Hasetset to store all the nums
//then keep increase current element by 1, then to check if the new element is exist in the hashset or not
public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        HashSet<Integer> set = new HashSet<>();
        for (Integer num : nums) {
            set.add(num);
        }

        //Iterator the nums to find The longest consecutive elements sequence
        //if we find a element, this element-1 is not exist in the hast, then current element is possible smallest consecutive element
        //then we will keep add+1 to this element to check if added element is exist into the hashset or not

        int longest = 1;
        for(Integer num : nums) {
            if(!set.contains(num-1)) {
                int length = 1;
                while(set.contains(++num))
                {
                    length++;
                }
                longest = Math.max(longest,length);
            }
        }
        return longest;
    }
}
