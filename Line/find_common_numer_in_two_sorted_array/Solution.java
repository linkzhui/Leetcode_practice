package Google.Line.find_common_numer_in_two_sorted_array;

import java.util.List;

public class Solution {
    public static void main(String[] args)
    {
        int[] a = {1,2,4,6,7};
        int[] b = {3,4,5};
        Solution sol = new Solution();
        System.out.println(sol.solution(a,b));
    }
    public int solution(int[] a,int[] b)
    {
        //asumption:    1. the sort way(ascending way or descending way)
        //              2. the relationship between a.length and b.length
        //              3. data type in array
        //              N = a.length    M = b.length
        //solution 1:   use hashset         time: O(N+M)        Space: O(N)
        //solution 2:   use two index       time: O(N+M)        Space: O(1)
        //solution 3:   use binary search   time: O(Nlog(M))    Space: O(1)

        if(a.length==0||b.length==0||a==null||b==null)
        {
            return -1;
        }

        for(int i = 0;i<b.length;i++)
        {
            if(binary_search(a,b,i)){
                return b[i];
            }
        }
        return -1;
    }

    public boolean binary_search(int[] a,int[] b,int index)
    {
        int left = 0;
        int right = b.length;
        int target = b[index];
        int mid = 0;
        while(left<right)
        {
            mid = left+(right-left)/2;
            if(a[mid]==target)
            {
                return true;
            }
            else if(mid>target)
            {
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }

        return false;

    }
}
