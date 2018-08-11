package Google.Line.leetcode_347_Top_K_Frequent_Elements;

import java.util.*;

public class Solution {

    public List<Integer> topKFrequent(int[] nums, int k) {
        if(nums==null||nums.length==0||k==0)
        {
            return null;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer,Integer>> MinHeap = new PriorityQueue<>(k,(a,b)->(a.getValue().compareTo(b.getValue())));
        List<Integer> result = new LinkedList<>();
        for(int i = 0;i<nums.length;i++)
        {
            if(map.containsKey(nums[i]))
            {
                map.put(nums[i],map.get(nums[i])+1);
            }
            else{
                map.put(nums[i],1);
            }
        }
        Iterator it = map.entrySet().iterator();
        while (it.hasNext())
        {
            Map.Entry pair = (Map.Entry)it.next();
            if(MinHeap.size()!=k)
            {
                MinHeap.add(pair);
            }
            else if((Integer)pair.getValue()>MinHeap.peek().getValue())
            {
                MinHeap.poll();
                MinHeap.add(pair);
            }

        }
        for(int i =0;i<k;i++)
        {
            Integer value = MinHeap.poll().getKey();

            result.add(value);
        }
        return result;
    }
}
