package Google.Line.leetcode_76_minimum_window_substring;

/**
 * Created by raymon on 7/13/17.
 *
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

 For example,
 S = "ADOBECODEBANC"
 T = "ABC"
 Minimum window is "BANC".

 Note:
 If there is no such window in S that covers all characters in T, return the empty string "".

 If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class Solution {
    public String minWindow(String s, String t) {
        int[] freqs = new int[256];
        int[] freqt = new int[256];
        for (int i = 0; i < t.length(); i++) {
            freqt[t.charAt(i)]++;
        }
        int start = 0;  //the start index of the string in string s
        int count = 0; //count shows how many element from T have been found
        String result = "";
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);

            if(freqt[c]>0)
            {
                freqs[c]++;
                if(freqs[c]<=freqt[c])
                {
                    count++;
                }
                if(count==t.length())
                {
                    while(!(freqt[s.charAt(start)]>0&&freqs[s.charAt(start)]==freqt[s.charAt(start)]))
                    {
                        freqs[s.charAt(start++)]--;

                    }
                    if(result==""||result.length()>i-start+1)
                    {
                        result = s.substring(start,i+1);
                    }
                }

            }
        }
        return result;
    }
}
