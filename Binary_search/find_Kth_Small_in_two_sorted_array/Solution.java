package Google.Binary_search.find_Kth_Small_in_two_sorted_array;

//binary search的做法，每次减少k/2的数量
//比较A[k/2-1]和B[k/2-1],哪边小就舍弃哪边
public class Solution {
    //a_left == left index in the a;
    public int findKthSmall (int[] A, int a_left, int[] B, int b_left, int k) {
        if (a_left >= A.length) {
            return B[b_left + k - 1];    //base 1: if a_left reach a.size();
        }
        if (b_left >= B.length) {
            return A[a_left + k  - 1];
        }
        if (k == 1) {
            return Math.min(A[a_left],B[b_left]);
        }

        //since index is from 0, so the k/2 the element should be = left + k/2 -1;
        //why is correct? if a.size too small, then remove element from b first
        //     原理： A array 剩余的数量少于k/2, 所以为了补充A里面少的数量的元素，需要从B的 k/2后面拿元素补充给A, 才能让两个array的length相等， 因为B[k/2-1] 一定比 B [i] 要小，（index i from k/2 to k - 1）,
        //     所以B【k/2 -1】都可以删掉
        int a_half_kth = a_left + k/2 - 1 < A.length? A[a_left + k/2 -1] : Integer.MAX_VALUE;
        int b_half_kth = b_left + k/2 - 1 < B.length? B[b_left + k/2 -1] : Integer.MAX_VALUE;

        if (a_half_kth < b_half_kth) {
            //A的k/2 - 1可以删掉
                                                                      //这里为什么是k - k/2，不是直接k/2是因为要满足奇数的情况
            return findKthSmall(A, a_left + k/2, B, b_left, k - k/2);
        } else {
            return findKthSmall(A, a_left, B, b_left + k/2, k - k/2);
        }
    }
}
