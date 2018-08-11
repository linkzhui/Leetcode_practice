package Google.Tree.print_all_subsets_of_a_set;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by raymon on 7/16/17.
 */
public class Solution {
    public static void main(String[] args)
    {
        LinkedList<String> result = new LinkedList<>();
        Solution sol = new Solution();
        Deque<Character> stack = new ArrayDeque<>();
        sol.solution("abc",0,stack,result);
        System.out.println(Arrays.toString(result.toArray()));
    }
    public void solution(String s, int index,Deque<Character> stack,LinkedList<String> result){
        if(index == s.length())
        {
            result.add(stack.toString());
            return;
        }
        stack.offerFirst(s.charAt(index));
        solution(s,index+1,stack,result);
        stack.removeFirst();
        solution(s,index+1,stack,result);

    }
}
