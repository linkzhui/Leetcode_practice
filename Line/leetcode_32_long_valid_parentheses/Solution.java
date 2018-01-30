package Google.Line.leetcode_32_long_valid_parentheses;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by raymon on 7/15/17.
 */

public class Solution {
    public int longestValidParentheses(String s) {
        if (s.length() == 0 || s == null) {
            return 0;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int length = 0;
        stack.offerFirst(-1);
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='(')
            {
                stack.offerFirst(i);
            }

            else{
                stack.removeFirst();
                if(stack.isEmpty())
                {
                    stack.addFirst(i);
                }
                else{
                    length = Math.max(length,i-stack.peek());
                }
            }
        }
        return length;

    }
}
/**
public class Solution {
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        String abc = "()()";
        System.out.println(sol.longestValidParentheses(abc));
    }
    public int longestValidParentheses(String s) {
        if(s.length()==0||s==null)
        {
            return 0;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        //这里不能把character给push进去，因为有可能跑到里面有多个左括号，却只有一个右括号的时候，
        //就没有办法处理了
        //stack里的-1代表从0开始的最长valid parentheses string
        int length = 0;
        stack.offerFirst(-1);
        for(int i =0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            {
                stack.offerFirst(i);

            }
            else{

                stack.removeFirst();
                if(stack.isEmpty())
                {
                    stack.push(i);
                }
                else{
                    length = Math.max(length,i-stack.peekFirst());
                }
            }
        }
        return length;
    }
}
*/