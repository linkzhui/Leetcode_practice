package Google.Tree.find_all_valid_permutation_of_string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


//1. what does it store on each level?
//          n levels, each level represents we consider 1 position
//how many different states should we try to put on this level?
//          position 0: n branches, position 1: n-1 branches
public class Solution {

    public static void main(String[] args)
    {
        List<String> result = new ArrayList<>();
        char[] s = {'a','b','b','c','d'};
        Solution sol = new Solution();
        result=sol.permutation_repeated_char(s);
        System.out.println(Arrays.toString(result.toArray()));
        System.out.println(result.size());
    }

    public void permutation_unrepeated_char(char[] s, int level,List<String> result){
        if(s.length==0||s==null)
        {
            return;
        }
        if(level==s.length)
        {
            result.add(Arrays.toString(s));
            return;
        }
        for(int i =level;i<s.length;i++)
        {
            swap(s,level,i);
            permutation_unrepeated_char(s,level+1,result);
            swap(s,level,i);
        }
        return;

    }

    public void swap(char[] s,int left, int right)
    {
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
    }

    public List<String> permutation_repeated_char(char[] s)
    {
        List<String> result = new ArrayList<>();

        if(s.length==0||s==null)
        {
            return result;
        }

        HashSet<char[]> set = new HashSet<>();
        helper(s,0,result,set);
        return result;
    }

    public void helper(char[] s, int level, List<String> result, HashSet<char[]> set){

        //base case
        if(level==s.length)
        {
            result.add(Arrays.toString(s));
            return;
        }
        for(int i = level;i<s.length;i++)
        {
            swap(s,level,i);
            char[] sub_array = Arrays.copyOf(s,level+1);
            if(!set.contains(sub_array))
            {
                set.add(sub_array);
                helper(s,level+1,result,set);
            }
            swap(s,level,i);
        }

    }

}
