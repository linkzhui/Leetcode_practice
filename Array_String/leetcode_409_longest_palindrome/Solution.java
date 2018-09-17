package Google.Line.leetcode_409_longest_palindrome;

import java.util.HashSet;

//Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
//
//This is case sensitive, for example "Aa" is not considered a palindrome here.
//
//Note:
//Assume the length of given string will not exceed 1,010.
//
//Example:
//
//Input:
//"abccccdd"
//
//Output:
//7
//
//Explanation:
//One longest palindrome that can be built is "dccaccd", whose length is 7.


//解题思路：通过hashset来对对碰，然后判断hashset的size是不是空，不是空的话再加1
public class Solution {
    public int longestPalindrome(String s) {
        if(s==null || s.length()==0)
        {
            return 0;
        }
        int count = 0;
        HashSet<Character> set = new HashSet<>();
        for(int i = 0;i<s.length();i++)
        {
            if(set.add(s.charAt(i))==false)
            {
                set.remove(s.charAt(i));
                count++;
            }
        }
        return set.isEmpty()? count*2:count*2+1;
    }
}
