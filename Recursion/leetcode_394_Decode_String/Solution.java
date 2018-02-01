package Google.Recursion.leetcode_394_Decode_String;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public static void main(String[] args)
    {
        String input = "3[a]2[bc]";
        Solution sol = new Solution();
        System.out.println(sol.decodeString(input));
    }
    public String decodeString(String s) {
        if(s == null || s.length()==0)
        {
            return "";
        }

        Deque<String> stack_str = new ArrayDeque<>();
        Deque<Integer> stack_int = new ArrayDeque<>();
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while(index<s.length())
        {
            if(Character.isDigit(s.charAt(index)))
            {
                int temp_index = index;
                while(Character.isDigit(s.charAt(index)))
                {
                    index++;
                }
                int num = Integer.parseInt(s.substring(temp_index,index));
                stack_int.offerLast(num);
            }
            else if(s.charAt(index) == '[')
            {
                stack_str.offerLast(sb.toString());
                sb = new StringBuilder();
                index++;
            }
            else if(s.charAt(index) == ']')
            {
                StringBuilder temp_sb = new StringBuilder(stack_str.pollLast());
                int repeat_time = stack_int.pollLast();
                for(int i = 0;i<repeat_time;i++)
                {
                    temp_sb.append(sb);
                }
                sb = temp_sb;
                index++;
            }
            else{
                sb.append(s.charAt(index++));
            }
        }
        return sb.toString();
    }
}
