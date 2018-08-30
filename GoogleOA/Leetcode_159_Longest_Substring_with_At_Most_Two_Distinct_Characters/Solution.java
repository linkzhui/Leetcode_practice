package Google.GoogleOA.Leetcode_159_Longest_Substring_with_At_Most_Two_Distinct_Characters;

public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || s.length() == 0)
        {
            return  0;
        }
        int[] map = new int[256];
        int count = 0;
        char[] array = s.toCharArray();
        int result = 0;
        int start_index = 0;
        for(int i = 0;i<s.length();i++)
        {
            char element = array[i];
            map[element]++;
            count = map[element] == 1? count+1:count;
            while(count>2)
            {
                char temp_element = array[start_index];
                map[temp_element]--;
                start_index++;
                if(map[temp_element] == 0)
                {
                    count --;
                    break;
                }
            }

            result = Math.max(result,i - start_index+1);
        }
        return result;
    }
}
