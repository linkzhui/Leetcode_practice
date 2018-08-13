package Google.Binary_search.classic;

public class Solution {
    public static void main(String[] args)
    {
        int[] array = {2};
        Solution sol = new Solution();
        System.out.println(sol.binary_search(array,2));
    }
    int binary_search(int[] array, int target)
    {
        if(array.length==0||array==null)
        {
            return -1;
        }
        int left = 0;
        int right = array.length-1;
        int mid = 0;
        while(left<=right)
        {
            //这里必须要等于号，因为要考虑一个元素的情况
            mid = left+(right-left)/2;
            if(array[mid] == target)
            {
                return mid;
            }
            else if(array[mid]<target)
            {
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return -1;
    }

}
