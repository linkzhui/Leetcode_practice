package Google.DP.Dictionary_problem;

import java.util.HashSet;
import java.util.Set;

//Question: Given a word, can it be composed by concatenating words
// from a given dictionary?
//Example:
//Dictionary:
//bob
//cat
//rob
public class Solution {
    public static void main(String[] args)
    {
        String[] dict = {"bob","cat","robsad","rob","sad","a"};
        Solution sol = new Solution();
        System.out.println(sol.dict_3(dict,"a"));

    }
    boolean dict_1(String[] dict, String s)
    {
        //时间： O（n*dict.length()）
        if(s==null || s.length()==0)
        {
            return false;
        }
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i = 1;i<=s.length();i++)
        {
            for(String word:dict)
            {
                if(i-word.length()<0)
                {
                    //current substring length is less than word length
                    continue;
                }
                if(s.substring(i-word.length(),i).equals(word) && dp[i-word.length()]){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    boolean dict_2(String[] dict,String s)
    {
        //左大段，右小段
        //这里的小段的意思是manual check

        if(s==null || s.length()==0)
        {
            return false;
        }
        Set<String> set = new HashSet<>();
        for(int i = 0;i<dict.length;i++)
        {
            set.add(dict[i]);
        }
        boolean[] dp = new boolean[s.length()+1];
        dp[0] =true;
        for(int i = 1;i<=s.length();i++)
        {
            for(int j =1;j<=i;j++)
            {
                // if(dp[j-s.substring(i-j,i).length()] && set.contains(s.substring(i-j,i)))

                if(dp[j-s.substring(i-j,i).length()] && set.contains(s.substring(i-j,i)))
                {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    boolean dict_3(String[] dict, String s)
    {
        if(s==null || s.length()==0)
        {
            return false;
        }

        Set<String> set = new HashSet<>();
        for(int i = 0;i<dict.length;i++)
        {
            set.add(dict[i]);
        }

        boolean[] dp = new boolean[s.length()+1];
        //the index of dp represents the if the length of substring is index (substring's start index begin from 0)

        dp[0] = true;

        for(int i = 1;i<=s.length();i++)
        {
            //traverse the string
            for(int j = 1;j<=i;j++)
            {
                if(dp[j-1] && set.contains(s.substring(j-1,i)))
                {
                    //发现substring 从j-1 到 i 存在字典里，就需要判断这个substring之前的是不是已经是配对好的 那就检查 dp[j-1]
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }


}
