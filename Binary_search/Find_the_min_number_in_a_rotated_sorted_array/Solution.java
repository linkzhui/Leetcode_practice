package Google.Binary_search.Find_the_min_number_in_a_rotated_sorted_array;



public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] array = {3,1,2};
        System.out.println(sol.findMin_no_dup(array));
    }

    //The minimum element must satisfy one of two conditions: 1) If rotate, A[min] < A[min - 1];
    // 2) If not, A[0]. Therefore, we can use binary search: check the middle element,
    // if it is less than previous one, then it is minimum.
    // If not, there are 2 conditions as well: If it is greater than both left and right element,
    // then minimum element should be on its right, otherwise on its left.

    //case 1: unrotated nums[0] < nums[last], then nums[0] is min
    //case 2: rotated, normally, the sorted array is ascending order, if we find a descending order, then we find the anwser
    public int findMin_no_dup(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = (right - left)/2 + left;
            if (mid > 0 && nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left]<nums[right]? nums[left]:nums[right];
    }


    public int findMin_dup(int[] num) {
        int lo = 0;
        int hi = num.length - 1;
        int mid = 0;

        while(lo < hi) {
            mid = lo + (hi - lo) / 2;

            if (num[mid] > num[hi]) {
                lo = mid + 1;
            }
            else if (num[mid] < num[hi]) {
                hi = mid;
            }
            else { // when num[mid] and num[hi] are same
                hi--;
            }
        }
        return num[lo];

    }
}
