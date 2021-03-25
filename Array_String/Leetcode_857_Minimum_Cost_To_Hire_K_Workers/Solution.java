package Google.Array_String.Leetcode_857_Minimum_Cost_To_Hire_K_Workers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] quality = {10,20,5};
        int[] wage = {70,50,30};
        System.out.println(sol.mincostToHireWorkers(quality, wage, 2));
    }
    //1. we can pay one worker with the mininmum wage expectation
    //2. the rest worker must have lowwer (wage / quality) ratio than current worker, otherwise we cannot pay the choose worker with mininum wage expectation
    //condition 1: therefore we need to choose k workers, they have (wage / quality) ratio <= choose one (wage / quality) ratio
    //condtion 2: meanwhile, we need to pay minimum wages, therefore we also need to choose k smallest quality worker who meet the condition 1
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        Worker[] workers = new Worker[quality.length];
        for (int i = 0; i < quality.length; i++) {
            workers[i] = new Worker(quality[i],wage[i]);
        }
        Arrays.sort(workers,(a, b) -> Double.compare(a.ratio, b.ratio));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));
        int sumq = 0;
        double ans = 1e9;
        for (Worker worker: workers) {
            pq.offer(worker.quality);
            sumq += worker.quality;
            if (pq.size() > K)
                sumq -= pq.poll();
            if (pq.size() == K)
                ans = Math.min(ans, sumq * worker.ratio);
        }
        return ans;

    }

    private class Worker{
        int quality;
        int wage;
        double ratio;
        public Worker (int quality, int wage) {
            this.quality = quality;
            this.wage = wage;
            this.ratio = (double) wage / quality;
        }
    }
}
