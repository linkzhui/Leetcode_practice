package Google.Line.leetcode_378_kth_smallest_element_in_a_sorted_matrix;

import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        int[][] matrix = {{ 1,  5,  9},
                {10, 11, 13},
                {12, 13, 15}};
        System.out.println(sol.kthSmallest(matrix,8));
    }
    public int kthSmallest(int[][] matrix, int k) {
        if(k<=0||matrix==null||matrix[0].length*matrix.length<k)
        {
            return -1;
        }

        PriorityQueue<element> pq = new PriorityQueue<>((a, b)->(a.val-b.val));
        for(int i =0;i<matrix.length;i++)
        {
            pq.offer(new element(0,i,matrix[i][0]));
        }
        int count = 0;
        while(k>count&&!pq.isEmpty())
        {
            element a = pq.poll();
            count+=1;
            if(k==count)
            {
                return a.val;
            }
            int x_index = a.x+1;
            int y_index = a.y;
            if(x_index<matrix[y_index].length)
            {
                pq.offer(new element(x_index,y_index,matrix[x_index][y_index]));

            }

        }
        return -1;

    }

    private class element{
        int x;
        int y;
        int val;
        public element(int x,int y,int val)
        {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
}

