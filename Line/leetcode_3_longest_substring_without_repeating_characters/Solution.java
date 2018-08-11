package Google.Line.leetcode_3_longest_substring_without_repeating_characters;

import java.util.Arrays;

/**
 * Created by raymon on 7/12/17.
 */
public class Solution {
    public int lengthOfLongestSubstring(String s)
    {
        if(s==null||s.length()==0)
        {
            return 0;
        }
        int[] map = new int[256];
        int length = 0;
        int start_index=0;
        Arrays.fill(map,-1);
        for(int i = 0;i<s.length();i++)
        {
            int element = s.charAt(i);
            if(map[element]!=-1){
                //这里少考虑了一个情况，当碰到重复的元素的时候，(如果新的length比现在的length要大，需要更新length，不然不更新)同时，也要更新start_index 和 end_index
                int temp = map[element];

                for(int j = start_index;j<=temp;j++){
                    map[s.charAt(start_index++)]=-1;
                }
                //start_index=temp+1;

            }
            length=Math.max(i-start_index+1,length);
            map[element]=i;
        }
        return length;
    }
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        String s = "pwwkew";
        System.out.println(solution.lengthOfLongestSubstring(s));
    }
}
