package Google.Array_String.AbbrevMatch;


// s1 = "a4c",    s2 = "abdbac"
public class Solution {
    public boolean abbrevMatch (String s1, String s2) {
        if ((s1 == null && s2 ==  null) || (s1.length() == 0 &&s2.length() == 0)) {
            return false;
        }
        return helper(0,0,s1,s2);

    }

    private boolean helper (int index_1, int index_2, String s1, String s2) {
        if (index_1 == s1.length() && index_2 == s2.length()) {
            return true;
        } else if (index_1 > s1.length() || index_2 > s2.length()) {
            return false;
        }
        if (Character.isDigit(s1.charAt(index_1))) {
            int i = 0;
            int digital  = 0;
            while(Character.isDigit(s1.charAt(index_1+i)) && i < s1.length()) {
                i++;
                digital = digital*10 + s1.charAt(i) - '0';
            }
            if (digital + index_2 > s2.length()) {
                return false;
            } else {
                return helper(index_1 + i, index_2 + digital, s1, s2);
            }
        } else {
            //case 2: letter
            if(s1.charAt(index_1) != s2.charAt(index_2)) {
                return false;
            } else {
                return helper(index_1+1,index_2+1,s1,s2);
            }
        }
    }
}
