package Google.Array_String.Leetcode_17_Letter_Combinations_of_a_Phone_Number;


//time complexity: O(n*m)  n:length of the string   m:number of characters in this digits
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<>();
        if(digits==null || digits.length()==0)
        {
            return result;
        }
        String[] input = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        StringBuilder sb = new StringBuilder();
        helper(sb,input,0,digits,result);
        return result;
    }

    private void helper(StringBuilder sb, String[] input,int index, String digits, List<String> result)
    {
        if(index==digits.length())
        {
            result.add(sb.toString());
            return;
        }
        int num = digits.charAt(index)-'0';
        for(int i = 0;i<input[num].length();i++)
        {
            sb.append(input[num].charAt(i));
            helper(sb,input,index+1,digits,result);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
