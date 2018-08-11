package Google.String.Leetcode_20_Valid_Parentheses;




import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        boolean result = sol.isValid("()");
        System.out.println(result);
    }
    public boolean isValid(String s)
    {
        Deque<Character> stack = new ArrayDeque();
        for(Character element:s.toCharArray())
        {
            if(element == '(' || element == '{' || element == '[')
            {
                stack.offerLast(element);
            }
            else{
                if(stack.isEmpty())
                {
                    return false;
                }
                Character temp = stack.pollLast();

                if((element==')' && temp=='(')|| (element=='}' && temp=='{')||(element==']' && temp=='['))
                {
                    continue;
                }
                else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
