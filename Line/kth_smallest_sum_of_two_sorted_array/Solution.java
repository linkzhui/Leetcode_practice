package Google.Line.kth_smallest_sum_of_two_sorted_array;

//given two sorted arrays A and B, with their sizes to be m and n, respectively. We can pick one element a from A
//and the other element b from B, and their sum s is defined to be s = a+b. How to find k-th smallest s from
//all possible values of s.

import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        int[] A = {0,1,3};
        int[] B = {0,2,4};
        int k = 4;
        for(int i = 1;i<=k;i++)
        {
            System.out.println(sol.kthSmallest(A,B,i));
        }
    }
    public int kthSmallest(int[] A,int[] B,int k)
    {
        //asumption: elements in array are integers
        //A and B is not null, nor is of length 0
        //return the k-th smallest sum
        PriorityQueue<Cell> pq = new PriorityQueue<>(2,(a, b)->((A[b.aidx]+B[b.bidx])-(A[a.aidx]+B[a.bidx])));
        pq.offer(new Cell(0,0));
        boolean[][] visited = new boolean[A.length][B.length];
        visited[0][0] = true;
        for(int i = 0;i<k-1;i++)
        {
            Cell temp = pq.poll();

            if(temp.aidx+1<A.length && !visited[temp.aidx+1][temp.bidx])
            {
                visited[temp.aidx+1][temp.bidx] = true;
                pq.offer(new Cell(temp.aidx+1,temp.bidx));
            }
            if(temp.bidx+1<B.length && !visited[temp.aidx][temp.bidx+1])
            {
                visited[temp.aidx][temp.bidx+1] = true;
                pq.offer(new Cell(temp.aidx,temp.bidx+1));
            }
        }
        Cell temp = pq.poll();
        return A[temp.aidx]+B[temp.bidx];

    }

    class Cell{
        int aidx;
        int bidx;
        public Cell(int aidx,int bidx){
            this.aidx = aidx;
            this.bidx = bidx;
        }
    }


}

