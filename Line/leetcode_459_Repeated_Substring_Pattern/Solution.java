package Google.Line.leetcode_459_Repeated_Substring_Pattern;

//Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
//
//Example 1:
//Input: "abab"
//
//Output: True
//
//Explanation: It's the substring "ab" twice.
//Example 2:
//Input: "aba"
//
//Output: False
//Example 3:
//Input: "abcabcabcabc"
//
//Output: True
//
//Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)


//Solution:
//the substring's length must can be divide by s.length();
//the substring's last character must be s.charAt(s.length()-1)

public class Solution {
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        String s = "abab";
        System.out.println(sol.repeatedSubstringPattern(s));
    }
    public boolean repeatedSubstringPattern(String s) {
        //the s.length divide by substring.length == 0
        //the substring's first character is s.charAt(0), and substring's last character is s.charAt(s.length()-1)
        if(s == null || s.length()==0)
        {
            return false;
        }
        char first_char = s.charAt(0);
        char last_char = s.charAt(s.length()-1);

        for(int i = 0;i<s.length()/2;i++)
        {
            if(s.length()%(i+1)==0 && s.charAt(i)==last_char)
            {
                StringBuilder sb = new StringBuilder();
                String temp = s.substring(0,i+1);
                for(int j = 0;j<(s.length()/(i+1));j++)
                {
                    sb.append(temp);
                }
                if(sb.toString().equals(s))
                {
                    return true;
                }
            }
        }
        return false;
    }
}

