package Google.Recursion.Leetcode_301_Remove_Invalid_Parentheses;

import java.util.ArrayList;
import java.util.List;


//algorithm: if we find a unpaired parentheses, delete unpaired parentheses， keep recursion function to solve the rest string
//            for example, if we find a unpaired right parentheses, how to choose which parentheses we should delete?
//            answer is any right parentheses from last delete index to current unpaired right parentheses index,
//            in order to avoid the duplicated result, if we find continuous parentheses, we only delete the first one

//recursion function: void remove(String s, List<String> ans, int last_i, int last_j, char[] par)
//         String s is input string, List<String> is the result we need to return, int last_i is current index when we traverse the string,
//         int last_j is the last index we delete the unpaired parentheses,
//         char[] par we use to distinguish we need to delete unpaired left parentheses or right parentheses
public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        remove(s, ans, 0, 0, new char[]{'(', ')'});
        return ans;
    }

    //last_i: we need to know what is the current index in the string when we traverse the string
    //last_j: the begin index if we want to delete any unpaired parentheses
    //last_j - 1: the last index we delete unpaired parentheses

    private void remove(String s, List<String> ans, int last_i, int last_j, char[] par) {
        int left_count = 0;
        for (int cur_index = last_i; cur_index < s.length(); ++cur_index) {
            if (s.charAt(cur_index) == par[0]) left_count++;
            if (s.charAt(cur_index) == par[1]) left_count--;
            if (left_count >= 0) continue;
            for (int j = last_j; j <= cur_index; ++j) {
                if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1])) {
                    remove(s.substring(0, j) + s.substring(j + 1), ans, cur_index, j, par);
                }
            }
            //if we find a unpaired parentheses, we will delete any possible parentheses from last deleted index to cur_index,
            //and we use recursion to solve the rest string, since we already called recursion function in the nested for loop,
            // so the recursion function will end right here
            return;
        }

        //when cur_index is reach the end of the string, then we reverse the string to do another recursion to remove the unpaired left parentheses
        String reversed = new StringBuilder(s).reverse().toString();
        if (par[0] == '(') // finished left to right
            remove(reversed, ans, 0, 0, new char[]{')', '('});
        else // finished right to left
            ans.add(reversed);
    }
}
