package Google.Line.two_sum;


import java.util.Arrays;

//Assumption:
//1. is array sorted or not sorted
//2. what is the size of the array
//3. what is data type
//4. space optimize or time optimize
public class Solution {
    public boolean two_sum_1(int[] array, int target)
    {
        //the array is sorted
        // space optimize and time optimize

        //time complexity: O(n)
        //space complexity: O(1)

        // if the current sum result is bigger than target, then if we move start_index to right, we will not get result,
        // if we move end_index to to left, there will have change to find result.

        //if the current sum is smaller than than target, then we should keep end_index does not move and move start_index to the right to find the potential result
        if(array==null||array.length==0)
        {
            return false;
        }
        int start =0;
        int end = array.length-1;
        while(start<end)
        {
            int result = array[start]+array[end];
            if(result==target)
            {
                return true;
            }
            else if(array[start]+array[end]<target)
            {
                start++;
            }
            else{
                end--;
            }
        }
        return false;
    }

    public boolean two_sum_2(int[] array, int target)
    {
        //if array is non_sorted

        //for space optimize we can use sort_algorithm then use two_sum_1 to find solution
        //time complexity: O(nlogn+n)

        //for time optimize we can use hashmap
        //time complexity: O(n)
        //space complexity: O(n)
        return false;
    }


}
