package Google.Line.leetcode_38_count_and_say;

/**
 * Created by raymon on 6/22/17.
 */
public class leetcode_38_count_and_say {
    public static void main(String[] argv)
    {
        System.out.println(countAndSay(5));
    }
    private static String countAndSay(int n) {
        String number = "1";
        for(int i =2; i<=n; i++)
        {
            StringBuilder sb = new StringBuilder();
            int count = 0;
            char prev = ' ';
            for(int j =0; j<number.length(); j++)
            {
                if(prev==' '||prev==number.charAt(j))
                {
                    count++;
                }
                else{
                    sb.append(count);
                    sb.append(prev);
                    count=1;
                }
                prev=number.charAt(j);
            }
            sb.append(count);
            sb.append(prev);
            number = sb.toString();
        }
        return number;
    }
}


