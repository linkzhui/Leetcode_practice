package Google.Line.leetcode_266_palindrome_permutation;

//Given a string, determine if a permutation of the string could form a palindrome.
//
//For example,
//"code" -> False, "aab" -> True, "carerac" -> True.


import java.util.HashSet;


public class Solution {
    public boolean canPermutePalindrome(String s) {
        if(s==null || s.length()==0)
        {
            return false;
        }

        int count = 0;//用count来记录number of unpair element
        int[] map = new int[256];
        for(Character element:s.toCharArray())
        {
            if(++map[element]%2==1)
            {
                count++;
            }
            else{
                count--;
            }
        }
        return (count <= 1);
    }
}
