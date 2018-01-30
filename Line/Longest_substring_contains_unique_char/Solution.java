package Google.Line.Longest_substring_contains_unique_char;

public class Solution {
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        String s = "aaabcdee";
        s=sol.solution(s);
        System.out.println(s);
    }
    public String solution(String s)
    {
        if(s.length()==0||s==null)
        {
            return null;
        }
        char[] map = new char[256];
        int longest_length = 0;
        int start_index = 0;
        int temp_index = 0;
        for(int i = 0;i<s.length();i++)
        {
            map[s.charAt(i)]++;
            if(map[s.charAt(i)]!=1)
            {
                while(map[s.charAt(i)]!=1)
                {
                    map[s.charAt(temp_index++)]--;
                }
            }
            if(longest_length<i-temp_index+1)
            {
                longest_length = Math.max(longest_length,i-temp_index+1);
                start_index = temp_index;
            }

        }
        s=s.substring(start_index,longest_length+start_index);
        return s;
    }

}
