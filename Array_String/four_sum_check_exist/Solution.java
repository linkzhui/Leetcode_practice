package Google.Line.four_sum_check_exist;

import java.util.HashMap;
import java.util.Map;


public class Solution {
    public boolean existIII(int[] array,int target)
    {
        if(array.length==0||array==null||array.length<4)
        {
            return false;
        }

        Map<Integer,pair> map = new HashMap<>();
        for(int j = 1; j<array.length;j++)
        {
            //the right index
            for(int i = 0;i<j;i++)
            {
                //the left index
                int pairsum = array[i] + array[j];
                if(map.containsKey(target-pairsum) && map.get(target - pairsum).right<i)
                {
                    return true;
                }
                if(!map.containsKey(target-pairsum)){
                    map.put(pairsum,new pair(i,j));
                }
            }
        }
        return false;
    }

    class pair{
        int left;
        int right;
        public pair(int left, int right)
        {
            this.left = left;
            this.right = right;
        }
    }
}
