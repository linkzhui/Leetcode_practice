package Google.DP.minimum_swaps_to_make_sequences_increasing;

//at index i, we have two options:
//1. swap element at current index
//2. doesn't swap element at current index

//swap[] and no_swap[]

//at what condition, we cannot swap current index
//1. if A[i-1] >= B[i] or B[i-1] >= A[i]
//swap[i] = swap[i-1] + 1
//no_swap[i] = no_swap[i-1] ??

//at what condition, we need to swap current index
//1. A[i-1] < A[i] or B[i-1] < B[i]

//the rest condition, you can swap or doesn't swap, no changes

//public class Solution {
//    public int minSwap(int[] A, int[] B) {
//
//    }
//}
