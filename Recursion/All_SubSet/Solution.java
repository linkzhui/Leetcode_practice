package Google.Recursion.All_SubSet;

import java.util.ArrayList;
import java.util.List;

//all subset: {a,b,c} -> {{a}, {b}, {c}, {a,b}, {a,c}, {b,c}}
//Recursion: the recursion level will be n (n is the size of the input array)
//at each level i, we have two choices, 1: we add add array[i] to the result      2: we don't add array[i] into the result
public class Solution {
    public List<List<Integer>> subset (int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(array, path, result, 0);
        return result;
    }

    private void helper (int[] array, List<Integer> path, List<List<Integer>> result, int index) {
        if (index == array.length) {
            result.add (new ArrayList<>(path));
            return;
        }

        //add current element into the result
        path.add(array[index]);
        helper(array, path, result, index + 1);

        //don't add current element into the result
        path.remove(path.size()-1);
        helper(array,path,result,index + 1);
    }
}
