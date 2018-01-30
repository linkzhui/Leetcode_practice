package Google.Line.String_En_Decording;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        String s = "aadabccaaaa";
        char[] array = new char[s.length()];
        for(int i =0;i<s.length();i++)
        {
            array[i]=s.charAt(i);
        }
        array=sol.String_encoding(array);
        System.out.println(Arrays.toString(array));
    }
    public char[] String_encoding(char[] s)
    {
        if(s==null||s.length==0)
        {
            return null;
        }
        int count = 1;
        char prev = s[0];
        int start_index = 0;
        int single_element_count = 0;
        int size = s.length;
        int total_num_count=0;
        for(int i = 1;i<=s.length;i++)
        {


            if((i==s.length||s[i]!=prev) && count == 1)
            {
                s[start_index++]= s[i-1];
                single_element_count++;
                count=1;
                prev= i==s.length? ' ':s[i];
            }

            else if((i==s.length||s[i]!=prev) && count != 1){
                prev= i==s.length? ' ':s[i];
                s[start_index++]=s[i-1];
                String count_num = Integer.toString(count);
                for(int j = 0;j<count_num.length();j++)
                {
                    s[start_index++]=count_num.charAt(j);
                }
                count=1;
                total_num_count+=2;
            }
            else if(s[i]==prev)
            {
                count++;
            }

        }


        char[] new_array = new char[total_num_count+single_element_count*2];

        int fast_index = total_num_count+single_element_count*2-1;
        for(int i = total_num_count+single_element_count-1;i>=0;i--)
        {
            if((i==size-1&&isCharacter(s[i]))||isCharacter(s[i])&&isCharacter(s[i+1]))
            {
                new_array[fast_index--]='1';

            }
            new_array[fast_index--] = s[i];
        }

        return new_array;

    }

    private boolean isCharacter(char a)
    {
        if(('a'<=a&&a<='z')||('A'<=a&&a<='Z'))
        {
            return true;
        }
        else{
            return false;
        }
    }

}

