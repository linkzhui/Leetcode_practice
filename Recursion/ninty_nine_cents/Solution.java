package Google.Recursion.ninty_nine_cents;


import java.util.ArrayList;
import java.util.List;

//recursion: number of recursion level is
public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] array = {1,5,10,25,50,75};
        List<List<String>> result;
        result = sol.ninty_nine_cents(array,11);
        System.out.println(result.size());

    }
    public List<List<String>> ninty_nine_cents(int[] array, int target) {
        if (array == null || array.length == 0) {
           return null;
        }
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        helper(array, result, path, array.length - 1, target);
        return result;
    }

    private void helper (int[] array, List<List<String>> result, List<String> path, int index, int target) {
        if (index == -1) {
            if (target == 0) {
                result.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = 0; i * array[index] <= target; i++) {
            path.add(i+"*"+array[index]);
            helper(array, result, path, index - 1, target - (i * array[index]));
            path.remove(path.size() - 1);
        }
    }
}
