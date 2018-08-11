package Google.String.Leetcode_38_Count_and_Say;


public class Solution {
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        String result = sol.countAndSay(4);
        System.out.println(result);
    }
    public String countAndSay(int n) {
        if(n<1)
        {
            return "";
        }
        StringBuilder result = new StringBuilder("1");
        if(n==1)
        {
            return result.toString();
        }
        StringBuilder sb;
        for(int i =2;i<=n;i++)
        {
            char prev = ' ';
            int count = 0;
            char[] result_array = result.toString().toCharArray();
            sb = new StringBuilder();
            for(int j = 0;j<result.length();j++)
            {
                if(prev == ' '||result_array[j]==prev)
                {
                    count++;
                }
                else{
                    sb.append(count);
                    sb.append(prev);
                    count=1;
                }
                prev = result_array[j];
            }
            sb.append(count);
            sb.append(prev);
            result = sb;
        }
        return result.toString();
    }
}
