package Google.Line.leetcode_266_palindrome_permutation;

//Given a string, determine if a permutation of the string could form a palindrome.
//
//For example,
//"code" -> False, "aab" -> True, "carerac" -> True.


import java.util.HashSet;

//解法思路：如果能permutatation之后组成回文，那就说明所有的character对对碰之后，hashset的size会少于等于1
public class Solution {
    public boolean canPermutePalindrome(String s) {
        if(s==null || s.length()==0)
        {
            return false;
        }
        HashSet<Character> set = new HashSet<>();
        for(int i = 0;i<s.length();i++)
        {
            char element = s.charAt(i);
            if(set.add(element)==false)
            {
                set.remove(element);
            }
        }
        return set.size()<=1;
    }
}
