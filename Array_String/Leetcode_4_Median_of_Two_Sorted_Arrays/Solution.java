package Google.Array_String.Leetcode_4_Median_of_Two_Sorted_Arrays;

//nums1: length is n
//nums2: length is m
//i is the point between 0 -> n, j is the point between 0 -> m
//left part of nums1 is 0 -> i-1, left part of nums2 is 0 -> j - 1
//if we can make sure two conditions: 1. length of left part of two array equal to length of right part of those two arry
//                                    2. max number from left part <= min number from the right part
//                                    then we find the median point
//condition 1. i + j = m - i + n - j;
//condition 2. nums1[i - 1] <= nums2[j] && nums2[j - 1] <= nums1[i]
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m > n)
        {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            int temp_int = m;
            m = n;
            n = temp_int;
        }
        int imin = 0;
        int imax = m;
        int halfLen = (m + n + 1) / 2;
        while (imin <= imax) {
            int i = (imax - imin)/2 + imin;
            int j = halfLen - i;
            if (i > imin && nums1[i-1] > nums2[j])
            {
                imax = i - 1;
            }
            else if (i < imax && nums2[j-1] > nums1[i]) {
                imin = i + 1;
            }
            else{
                // i is found
                //check the corner case, i = 0; i = m; j = 0;j = n;
                int leftmax;
                if(i == 0) {
                    leftmax = nums2[j-1];
                }
                else if(j == 0) {
                    leftmax = nums1[i-1];
                }
                else{
                    leftmax = Math.max(nums1[i-1], nums2[j-1]);
                }
                if(m+n % 2 == 1) {
                    return leftmax;
                }

                int rightmin;
                if(i == m) {
                    rightmin = nums2[j];
                }
                else if(j == n) {
                    rightmin = nums1[i];
                }
                else {
                    rightmin = Math.min(nums2[j], nums1[i]);
                }
                return (leftmax + rightmin) / 2.0;
            }
        }
        return 0.0;
    }
}
