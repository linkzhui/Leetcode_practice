package Google.Tree.find_all_valid_permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by raymon on 7/16/17.
 */
public class Solution {
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        LinkedList<List<Character>> result = new LinkedList<>();
        sol.permutation_bracket_2(3,0,0,new LinkedList<Character>(),result);
        System.out.println(Arrays.toString(result.toArray()));

    }

    public void permutation_bracket(int num,int left, int right,String cur,LinkedList<String> result){
        if(left==right&&left==num)
        {
            result.add(cur);
            return;
        }
        if(left<num)
        {
            permutation_bracket(num,left+1,right,cur+"(",result);
        }
        if(right<left)
        {
            permutation_bracket(num,left,right+1,cur+")",result);
        }
    }

    public void permutation_bracket_2(int n, int left, int right, List<Character> path, List<List<Character>> result) {
        if (left == right && left == n)
        {
            result.add(new ArrayList<>(path));
        }
        if(left<n)
        {
            path.add('(');
            permutation_bracket_2(n,left+1,right,path,result);
            path.remove(path.size()-1);
        }
        if(right<left)
        {
            path.add(')');
            permutation_bracket_2(n,left,right+1,path,result);
            path.remove(path.size()-1);
        }
    }

}


