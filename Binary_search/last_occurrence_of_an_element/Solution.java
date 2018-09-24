package Google.Binary_search.last_occurrence_of_an_element;

public class Solution {
    public static void main(String[] args)
    {
        int[] array = {1,2,3,3,3,3,3,3};
        Solution sol = new Solution();
        System.out.println(sol.find_first(array,3));
    }
    int finr_last_occurrence(int[] array, int target)
    {
        if(array==null||array.length==0)
        {
            return -1;
        }
        int left = 0;
        int right = array.length-1;
        int mid;
        while(left+1<right)
        {
            mid = left+(right-left)/2;
            if(array[mid]==target)
            {
                left = mid;
            }
            else if(array[mid]<target)
            {
                left = mid;
            }
            else{
                right = mid;
            }
        }
        if(target == array[right])
        {
            return right;
        }
        else if(target==array[left])
        {
            return left;
        }
        else{
            return -1;
        }
    }

    int find_first(int[] array, int target)
    {
        if(array==null||array.length==0)
        {
            return -1;
        }
        int left = 0;
        int right = array.length-1;
        int mid;
        while(left+1<right)
        {
            mid = left+(right-left)/2;
            if(array[mid]==target)
            {
                right = mid;
            }
            else if(array[mid]<target)
            {
                left = mid;
            }
            else{
                right = mid;
            }
        }
        if(target == array[left])
        {
            return left;
        }
        else if(target==array[right])
        {
            return right;
        }
        else{
            return -1;
        }
    }

}
