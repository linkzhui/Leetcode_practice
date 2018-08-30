package Google.data_structure.Heap;

import java.util.PriorityQueue;

class KthLargest {
    PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<Integer>();
        this.k = k;
        for(Integer element:nums)
        {
            pq.offer(element);
            if(pq.size()>k)
            {
                pq.poll();
            }
        }
    }

    public int add(int val) {
        pq.offer(val);
        if(pq.size()>k)
        {
            pq.poll();
        }
        return pq.peek();
    }
}