package Google.Array_List.Leetcode_14_Longest_Common_Prefix;


//time complex:O(S) S:all the string
//space complex: O(1) we only use constant extra space
public class Leetcode_14_Longest_Common_Prefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
        {
            return "";
        }
        String prefix = strs[0];
        for(int i = 1;i<strs.length;i++)
        {
            int j = 0;
            char[] current_array = strs[i].toCharArray();
            char[] prefix_1 = prefix.toCharArray();
            for(;j<Math.min(prefix_1.length,current_array.length);j++)
            {
                if(current_array[j]!=prefix_1[j])
                {
                    break;
                }
            }
            if(j<prefix.length())
            {
                prefix = prefix.substring(0,j);
            }

        }
        return prefix;
    }
}
