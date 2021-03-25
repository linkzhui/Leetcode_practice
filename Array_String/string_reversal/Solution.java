package Google.Line.string_reversal;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args){
        Solution sol = new Solution();
        char[] s = {'I',' ','L','O','V','E',' ','Y','A','H','O','O'};
        System.out.println(sol.reverseWord(s));
    }

    public void string_swap(char[] s)
    {
        int left = 0;
        for(int i = 0;i<s.length;i++)
        {
            if(i+1==s.length||(s[i+1]==' '))
            {
                int left_index = left;
                int right = i;
                while(left_index<right)
                {
                    swap(s,left_index++,right--);
                }
                left = i+2;
            }

        }
        left = 0;
        int right = s.length-1;
        while(left<right)
        {
            swap(s,left++,right--);
        }

    }

    public String reverseWord(char[] array) {
        if (array == null || array.length ==0) {
            return null;
        }
        int start = 0;
        while (start < array.length) {
            while (start < array.length && array[start] == ' ') {
                start++;
            }
            int begin = start;
            while (start < array.length && array[start] != ' ') {
                start++;
            }
            reverse(array, begin, start - 1);
        }
        reverse(array, 0 , array.length - 1);
        return new String(array);
    }

    private void reverse (char[] array, int start, int end) {
        while (start<end) {
            char temp = array[start];
            array[start++] = array[end];
            array[end--] = temp;
        }
    }


    public void swap(char[] s, int left, int right)
    {
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
    }
}
