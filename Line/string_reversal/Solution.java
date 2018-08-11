package Google.Line.string_reversal;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args){
        Solution sol = new Solution();
        char[] s = {'I',' ','L','O','V','E',' ','Y','A','H','O','O'};
        sol.string_swap(s);
        System.out.println(Arrays.toString(s));
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
    public void swap(char[] s, int left, int right)
    {
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
    }
}
