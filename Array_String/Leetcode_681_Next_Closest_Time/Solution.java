package Google.Array_String.Leetcode_681_Next_Closest_Time;

import java.util.HashSet;


//time complexity: O(1)  -> 4^4
//space complexity: O(1)
public class Solution {
    public String nextClosestTime(String time) {
        String hour = time.substring(0,2);
        String min = time.substring(3);
        HashSet<Integer> num = new HashSet<>();
        for(Character element:time.toCharArray())
        {
            if(element != ':')
            {
                num.add(element - '0');
            }
        }
        int start = Integer.parseInt(hour) * 60 + Integer.parseInt(min);
        //这里result = start是为了确保，如果没有找到答案，就返回自己，像特殊的case，11:11，这种特殊的case
        int result = start;
        int timeSpent = Integer.MAX_VALUE;
        for(int h1 : num) {
            for(int h2 : num) {
                if(h1 * 10 + h2 < 24) {
                    for(int m1 : num)
                    {
                        for(int m2 : num)
                        {
                            if(m1 * 10 + m2 < 60)
                            {
                                int curTime = (10*h1+h2)*60+m1*10+m2;
                                int curTimeSpent = Math.floorMod(curTime - start,60*24);
                                if(curTimeSpent>0 && curTimeSpent<timeSpent)
                                {
                                    result = curTime;
                                    timeSpent = curTimeSpent;
                                }
                            }
                        }
                    }
                }
            }
        }
        return String.format("%02d:%02d", result / 60, result % 60);

    }
}
