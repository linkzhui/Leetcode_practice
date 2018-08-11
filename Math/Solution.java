package Google.Math;

public class Solution {
    public int divide(int dividend, int divisor) {
//solution 2: bit operation: (better solution)
// 16 / 3 = 5 -> 1+4 -> (2^0+2^2) -> 2^0 * 3 + 2^2 * 3
//通过bit operation，找到solution bit的位置
        if (dividend == 0) {
            if (divisor == 0) {
                return Integer.MAX_VALUE;
            }
            return 0;
        }

        long result = 0;
        long dividend_num = dividend;
        long divisor_num = divisor;
        int sign = 1;

        if (dividend < 0) {
            dividend_num *= -1;
            sign *= -1;
        }

        if (divisor < 0)
        {
            divisor_num *= -1;
            sign *= -1;
        }

        while(dividend_num>=divisor_num)
        {
            long result2 = 1;
            long divisor_num_2 = divisor_num;
            while(dividend_num-(divisor_num_2<<1)>=0)
            {
                //每次让被除数乘以2，直到被除数非常接近除数（就是被除数再乘以2就会超过除数），
                //我们知道了这个被除数移动了多少步，这个步数就是我们要的solution的那个bit位置
                divisor_num_2<<=1;
                result2<<=1;
            }

            dividend_num = dividend_num-divisor_num_2;
            result |= result2; //这里的 | 是 or的意思，就是把当前的bit position加到result里面，
        }

        if(sign == -1) {
            result = -result;
            if (result < Integer.MIN_VALUE) {
                result = Integer.MAX_VALUE;
            }
        } else {
            if(result > Integer.MAX_VALUE) {
                result = Integer.MAX_VALUE;
            }
        }
        return (int) result;

    }
}
