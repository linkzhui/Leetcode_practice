package Google.Array_String.char_removal;

import java.util.Arrays;

//Question: Remove all leadig/trailing and duplicate empty spaces(only leave one empty sapce if duplicated spaces happen)
//from the input string
public class Solution {
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        char[] s = {' ',' ',' ','a','b','c',' ',' ',' ','d',' '};
        System.out.println(Arrays.toString(sol.char_removal(s)));

    }

    public char[] char_removal(char[] s)
    {
        if(s.length==0 || s==null)
        {
            return null;
        }
        int fast = 0;//cur index in the array
        int slow = 0; //slow: all the elements left side of the slow are the final result(exclude the slow)
        while(fast<s.length && s[fast]==' ')
        {
            fast++;
        }
        while(fast<s.length)
        {
            if(s[fast]!=' ')
            {
                swap(s,fast++,slow++);
            }

            else{
                //s[fast] == ' '
                fast++;
                while(fast<s.length && s[fast]== ' ')
                {
                    fast++;
                }
                if(fast!=s.length)
                {
                    s[slow++] = ' ';
                }
            }
        }

        char[] result = new char[slow];
        for(int i =0;i<=slow-1;i++)
        {
            result[i] = s[i];
        }
        return result;

    }

    void swap(char[] s, int left, int right)
    {
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
    }
}
