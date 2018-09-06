package Google.Array.Leetcode_729_My_Calendar_I;

import java.util.TreeMap;


//利用treemap来做
//time complexity: O(nlogn);
public class MyCalendar {
    TreeMap<Integer, Integer> calendar;
    public MyCalendar() {
        this.calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer prev = calendar.floorKey(start);
        Integer next = calendar.ceilingKey(start);
        if((prev == null || calendar.get(prev) <= start) && (next == null || next >= end)) {
            calendar.put(start,end);
            return true;
        }
        else{
            return false;
        }
    }
}
