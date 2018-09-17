package Google.Array_String.Leetcode_731_My_Calender_II;

import java.util.TreeMap;

//time complexity: O(n^2)
//space complexity: O(n)
public class MyCalendarTwo_2 {
    TreeMap<Integer,Integer> map;
    public MyCalendarTwo_2(){
        this.map = new TreeMap<>();
    }
    public boolean book(int start, int end) {
        map.put(start, map.getOrDefault(start,0)+1);
        map.put(end, map.getOrDefault(end,0)-1);
        int count = 0;
        for(Integer value:map.values())
        {
            count += value;
            if(count >= 3)
            {
                //after we add current event into calendar, the booking time exceed three times, therefore we need to remove current event out of our calendar.
                map.put(start, map.get(start) - 1);
                map.put(end, map.get(end) + 1);
                if (map.get(start) == 0)
                    map.remove(start);
                return false;
            }
        }
        return true;
    }
}
