package Google.Tree.Print_all_permutation_sum_up_to_k_value;


//Question: Print all combinations of coins that can sum up tp a total
//value k.
//E.g total value k = 99 cents
//coin value = 25 10 5 1

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    static int[] array = {1, 5, 10, 25};

    public static void main(String[] args){
        Solution sol = new Solution();
        List<List<String>> result = new LinkedList<>();
        List<String> path = new LinkedList<>();
        sol.FindCombination(99,0,path,result);
        System.out.println(result);
    }
    void FindCombination(int money_left, int level, List<String> path, List<List<String>> result) {
        if (money_left == 0)
        {
            result.add(new LinkedList<>(path));
            return;
        }

        if(money_left<0 || level==4)
        {
            return;
        }
        for(int i = 1;i<=money_left/array[level];i++)
        {
            String s = new String(i+"*"+array[level]);
            path.add(s);
            FindCombination(money_left-i*array[level],level+1,path,result);
            path.remove(path.size()-1);

        }

    }
}
