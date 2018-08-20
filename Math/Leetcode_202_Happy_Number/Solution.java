package Google.Math.Leetcode_202_Happy_Number;

import java.util.HashSet;

public class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (n!=1)
        {
            int result = 0;
            while(n!=0)
            {
                result+=(n%10)*(n%10);
                n = n/10;
            }
            if(!set.add(result))
            {
                return false;
            }
            n = result;
        }
        return true;
    }
}
