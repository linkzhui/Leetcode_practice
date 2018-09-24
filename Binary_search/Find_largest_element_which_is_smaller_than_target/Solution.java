package Google.Binary_search.Find_largest_element_which_is_smaller_than_target;

public class Solution {
    public static void main (String[] args) {
        Solution sol = new Solution();
        int[] array = {2};
        System.out.println(sol.find(array,1));
    }
    public int find (int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (right - left)/2+left;
            if(array[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return (left - 1 >= 0) ? left - 1 : -1;
    }
}
