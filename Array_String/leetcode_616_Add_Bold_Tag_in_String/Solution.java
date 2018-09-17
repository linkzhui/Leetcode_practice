package Google.Line.leetcode_616_Add_Bold_Tag_in_String;

//
public class Solution {
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        String input = "abcxyz123";
        String[] dict = {"abc","123"};
        System.out.println(sol.addoldTag(input,dict));

    }
    public String addoldTag(String s, String[] dict)
    {
        boolean[] array = new boolean[s.length()];
        int end = 0;
        for(int i = 0;i<s.length();i++)
        {
            for(String word:dict)
            {
                if(i+word.length()-1<s.length() && word.equals(s.substring(i,word.length()+i)))
                {
                    //这里要注意边界，i+word.length()-1才是字母的长度
                    end = Math.max(end,i+word.length());
                }
            }
            array[i] = i<end;
        }

        String prefix_head = "<b>";
        String prefix_end = "</b>";
        StringBuilder result = new StringBuilder();

        for(int i = 0;i<s.length();)
        {
            if(array[i]==true)
            {
                result.append(prefix_head);
                while(i<s.length() && array[i]==true )
                {
                    //这里要保证i不要越界
                    result.append(s.charAt(i++));
                    continue;
                }
                result.append(prefix_end);
            }
            else{
                result.append(s.charAt(i++));
            }
        }
        return result.toString();
    }
}
