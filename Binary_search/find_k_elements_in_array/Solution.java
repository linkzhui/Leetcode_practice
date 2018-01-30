package Google.Binary_search.find_k_elements_in_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        int[] array = {1,2,2,3,3,4,4,5,6,7,8};
        System.out.println(sol.k_element(array,7,4).toString());
    }
    List<Integer> k_element(int[] array, int target, int k)
    {
        List<Integer> result = new ArrayList<>();
        if(array==null||array.length==0||k>array.length)
        {
            return result;
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
            else if(array[mid]<target){
                left = mid;
            }
            else{
                right = mid;
            }
        }
        for(int i =0;i<k;i++)
        {
            if(Math.abs((array[left]-target))<Math.abs(array[right]-target))
            {
                result.add(array[left--]);
                if(left==-1){
                    while(i+1<=k-1) //consider if left cross the boundary
                    {
                        i++;
                        result.add(array[right++]);
                    }
                }
            }
            else{
                result.add(array[right++]);
                if(right==array.length){  //consider if right cross the boundary
                    while(i+1<=k-1)
                    {
                        i++;
                        result.add(array[left--]);
                    }
                }

            }
        }
        return result;
    }
}
