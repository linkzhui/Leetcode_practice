package Google.String.Leetcode_459_Repeated_Substring_Pattern;

public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() == 0)
        {
            return false;
        }
        int length = s.length();
        char[] word = s.toCharArray();
        char first = word[0];
        char last = word[length-1];

        for (int i = 0;i<s.length()/2;i++)
        {
            if(length % (i+1) == 0 && word[i] == last)
            {
                StringBuilder sb = new StringBuilder();
                String temp = s.substring(0,i+1);
                for(int j = 0; j < s.length() / (i+1); j++) {
                    sb.append(temp);
                }
                if(sb.toString().contains(s))
                {
                    return true;
                }
            }
        }
        return false;
    }
}
