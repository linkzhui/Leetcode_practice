package Google.DP.longest_ascending_array;

public class Solution {
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        int[] array = {1,2,3,4,2,3,4,2,3,4,5,6,7};
        System.out.println(sol.longest_ascending_array(array));
    }
    int longest_ascending_array(int[] array){
        if(array.length==0||array==null)
        {
            return 0;
        }
        int count = 1;
        int max_length = 1;
        for(int i = 1;i<array.length;i++)
        {
            if(array[i-1]<array[i])
            {
                count++;
            }
            else
            {
                max_length = Math.max(max_length,count);
                count = 1;
            }
        }
        max_length = Math.max(max_length,count);
        return max_length;
    }
}
