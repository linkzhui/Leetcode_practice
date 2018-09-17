package Google.Line.string_shuffling;

import java.util.Arrays;

import static java.lang.Math.abs;

public class Solution {
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        System.out.println("reverse order string shufflinf");
        char[] s = {'A','B','C','D','E','1','2','3','4','5'};
        sol.reverse_order_solution(s);
        System.out.println(Arrays.toString(s));
        System.out.println("in order string shufflinf");
        char[] s1= {'A','1','B','2','C','3','D','4','E','5'};
        sol.First_direction(s1,0,s1.length-1);
        System.out.println(Arrays.toString(s1));
    }
    public void reverse_order_solution(char[] s) {
        if (s.length == 0 || s == null)
        {
            return;
        }
        reverse_oder_helper(s,0,s.length-1);

    }

    public void reverse_oder_helper(char[] s, int left, int right)
    {
        if(right-left<=1)
        //only one character left
        {
            return;
        }
        int size = right-left+1;
        int left_mid = left + (size)/4;
        int mid = left + (size)/2;
        int right_mid = left + (size)*3/4;
        swap(s,left_mid,mid-1);
        swap(s,mid,right_mid-1);
        swap(s,left_mid,right_mid-1);
        reverse_oder_helper(s,left,left+2*(left_mid-left)-1);
        reverse_oder_helper(s,left+2*(left_mid-left),right);



    }
    public void swap(char[] s, int left, int right)
    {
        while(left<right)
        {
            char temp = s[left];
            s[left] = s[right];
            s[right]=temp;
            left++;
            right--;
        }

    }

    public void First_direction(char[] array, int left, int right)
    {
        if(left>=right)
        {
            return;
        }
        int mid = left+(right-left)/2;
        First_direction(array,left,mid);
        First_direction(array,mid+1,right);
        merge(array,left,right,mid);

    }

    void merge(char[] s,int left, int right,int mid){
        int size = right-left+1;
        char[] temp = new char[size];
        int first_index = left;
        int second_index = mid+1;
        int i = 0;
        while(first_index<=mid && second_index<=right)
        {
            if(s[first_index]<s[second_index])
            {
                temp[i++] = s[first_index++];
            }
            else{
                temp[i++] = s[second_index++];
            }
        }
        while(first_index<=mid)
        {
            temp[i++] = s[first_index++];
        }
        while(second_index<=right)
        {
            temp[i++] = s[second_index++];
        }
        for(i =0;i<size;i++)
        {
            s[left+i] = temp[i];
        }

    }


    private void swap_single_element(char[] s, int left, int right)
    {
        char temp = s[left];
        s[left] = s[right];
        s[right]=temp;
    }

}
