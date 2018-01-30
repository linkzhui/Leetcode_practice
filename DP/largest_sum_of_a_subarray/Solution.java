package Google.DP.largest_sum_of_a_subarray;


//Question: Gievn an unsorted array, find the subarray that has the greatest sum.
//Return the sum.
public class Solution {
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        int[] array = {-1,-2,4,-1,-2,10,-1};
        System.out.println(sol.largest_sum(array));
    }
    Integer largest_sum(int[] array)
    {
        //之前如果给的是正的contribution，就继承，不然cur_largest_sum就是自己
        if(array==null || array.length==0)
        {
            return null;
        }
        int temp_start_index = -1;
        int start_index = 0;
        int end_index = 0;
        int cur = 0;
        int global_max = Integer.MIN_VALUE;
        for(int i = 0;i<array.length;i++)
        {
            if(cur<=0)
            {
                cur = array[i];
                temp_start_index = i;
            }
            else{
                cur += array[i];
            }
            if(global_max < cur){
                global_max = cur;
                start_index = temp_start_index;
                end_index = i;
            }
        }
        System.out.println("the start index is "+ start_index);
        System.out.println("the end index is "+ end_index);
        return global_max;
    }

}
