package Google.DP.Leetcode_218_The_Skyline_Problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> building = new ArrayList<>();
        List<int[]> result = new ArrayList<>();
        for (int[] array : buildings) {
            //把building的坐标，heights加进来，building起始位置的heights设置为正数，结束的位置的heights设置为负数
            building.add(new int[]{array[0],array[2]});
            building.add(new int[]{array[1],-array[2]});
        }
        Collections.sort(building, (a, b) -> (a[0] == b[0]? b[1] - a[1] : a[0] - b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        int preMax = 0;
        pq.offer(0);
        //cirtical section就是当前的max heights变化了,就把位置记录下来
        for (int[] build : building) {
            if (build[1] < 0) {
                //heights小于0表示当前这个building的结束位置在这里，从pq里面移除height
                pq.remove(-build[1]);
            } else {
                pq.offer(build[1]);
            }
            if (preMax != pq.peek()) {
                //如果当前max heights有变化，记录下来
                result.add(new int[]{build[0], pq.peek()});
                preMax = pq.peek();
            }
        }
        return result;
    }
}
