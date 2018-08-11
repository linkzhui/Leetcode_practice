package Google.Math.Leetcode_43_Multiple_Strings;

public class Solution {
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        System.out.println(sol.multiply("498828660196","840477629533"));

    }
    public String multiply_1(String num1, String num2) {
        //assumption: if the result of answer may not in the range of long type can represent.

        int n1 = num1.length();
        int n2 = num2.length();
        int[] product = new int[n1+n2];
        for(int i = n1-1;i>=0;i--)
        {
            int d1 = num1.charAt(i)-'0';
            for(int j = n2-1;j>=0;j--)
            {
                int d2 = num2.charAt(j)-'0';

                //这里为什么要等于i+j+1，因为product的length是n1+n2,所以最后的一个元素的index是n1+n2-1 -> i+j+1
                product[i+j+1]+=(d1*d2)%10;

                product[i+j]+=(d1*d2)/10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int element:product)
        {
            sb.append(element);
        }

        while(sb.length()!=0 && sb.charAt(0) == '0')
        {
            sb.deleteCharAt(0);
        }

        return sb.length()==0? "0":sb.toString();

    }

    public String multiply(String num1, String num2) {
        //assumption: the result of answer must in the range of long type can represent.

        if(num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0)
        {
            return "";
        }

        long result = 0;
        for(int i = num2.length()-1;i>=0;i--)
        {
            long temp = 0;
            long num2_one = (long) ((num2.charAt(i)-'0')*(Math.pow(10,num2.length()-i-1)));
            for(int j = num1.length()-1;j>=0;j--)
            {
                temp+=(num1.charAt(j)-'0')*(Math.pow(10,num1.length()-1-j))*num2_one;
            }
            result+=temp;
        }
        return result+"";
    }
}
