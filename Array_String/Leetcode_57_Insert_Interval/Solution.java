package Google.Array_String.Leetcode_57_Insert_Interval;

import java.util.ArrayList;
import java.util.List;

//time complexity: O(n)
//space complexity: O(n)
//step1: add all the interval which the end time is less than newInterval's start time.
//step2: merge all the intervals which is overlaps with newInterval's
//step3: add rest intervals

//bouns: if the List<Interval> intervals is linkedList, we should use iterator to go through the array

public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        if(newInterval == null) {
            return result;
        }
        if (intervals == null || intervals.size() == 0) {
            result.add(0, newInterval);
            return result;
        }
        int curIndex = 0;
        while(curIndex < intervals.size() && intervals.get(curIndex).end < newInterval.start) {
            result.add(intervals.get(curIndex));
            curIndex++;
        }
        while(curIndex < intervals.size() && Math.max(intervals.get(curIndex).start, newInterval.start) <= Math.min(intervals.get(curIndex).end, newInterval.end) ) {
            newInterval.start = Math.min(intervals.get(curIndex).start, newInterval.start);
            newInterval.end = Math.max(intervals.get(curIndex).end, newInterval.end);
            curIndex++;
        }
        result.add(newInterval);
        while(curIndex < intervals.size()) {
            result.add(intervals.get(curIndex++));
        }
        return result;

    }

    private class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
}
