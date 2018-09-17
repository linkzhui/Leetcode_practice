package Google.Array_String.Leetcode_731_My_Calender_II;

import java.util.*;

//time complexity: O(n^2)
//space complexity: O(n)
public class MyCalendarTwo {
    List<int[]> calendar;
    List<int[]> overlap;
    public MyCalendarTwo() {
        this.calendar = new ArrayList<>();
        this.overlap = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] element : overlap) {
            if(Math.max(element[0],start) < Math.min(end, element[1]))
            {
                //the overlap already exist once, therefore the overlap cannot be more than 3 times
                return false;
            }
        }
        for(int[] element : calendar) {
            int temp_start = Math.max(start, element[0]);
            int temp_end = Math.min(end, element[1]);
            if(temp_start < temp_end) {
                overlap.add(new int[]{temp_start, temp_end});
            }
            calendar.add(new int[]{start, end});
        }
        return true;
    }
}
