package Google.Line.leetcode_228_summary_range;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by raymon on 6/22/17.
 */
public class leetcode_228_summary_range {
    public static void main(String[] argv)
    {
        int[] result = {0,1,2,4,5,7};
        List<String> result_1 = summaryRanges(result);
        System.out.println(result_1.size());
        /*
        for(int i =0;i<result_1.size();i++)
        {
            System.out.println(result_1.get(i));
        }
        */

    }
    private static List<String> summaryRanges(int[] nums) {
        List<String> result= new ArrayList<>();
        int count=1;
        for(int i = 1;i <= nums.length;i++)
        {
            if(i==nums.length||nums[i]!=nums[i-1]+1)
            {
                result.add((count==1? "":nums[i-count]+"->")+nums[i-1]);
                count=0;
            }
            count++;
        }
        return result;
    }
}
