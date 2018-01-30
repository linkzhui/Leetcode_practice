package Google.Tree.leetcode_93_Restore_IP_Addresses;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by raymon on 6/25/17.
 */
public class Helper_solution {
    public static void main(String[] args)
    {
        List<String> result = restoreIpAddresses("25525511135");
        for(int i = 0;i<result.size();i++)
        {
            System.out.println(result.get(i));
        }
    }
    public static List<String> restoreIpAddresses(String s) {
        List<String> result= new ArrayList<>();
        if(s.length()==0)
        {
            return result;
        }
        return helper(4,12,-1,"",s);
    }

    private static List<String> helper(int min, int max, int end, String cur, String s) {
        List<String> result= new ArrayList<>();
        if(min==0)
        {
            result.add(cur);
            return result;
        }
        int minchild = min-1;
        int maxchild = max-3;
        int startchild = end+1;
        for(int endchild = startchild;endchild<startchild+3;endchild++)
        {
            int remainlength = s.length()-endchild-1;
            if(minchild<=remainlength&&maxchild>=remainlength
                    &&Integer.valueOf(s.substring(startchild,endchild+1))<256
                    &&(startchild==endchild||s.charAt(startchild)!='0'))
            {
                List<String> resultchild = helper(minchild,maxchild,endchild,s.substring(startchild,endchild+1),s);
                if(end!=-1)
                {
                    for(String resultchild1:resultchild)
                    {
                        result.add(cur+'.'+resultchild1);
                    }
                }
                else{
                    result.addAll(resultchild);
                }
            }

        }
        return result;
    }

}
