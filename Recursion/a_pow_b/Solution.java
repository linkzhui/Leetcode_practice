package Google.Recursion.a_pow_b;

//Question: a ^
//time complex: O(log b)   每层只有1个分支，总共 log b层
//space complex: O(log b)
public class Solution {
    public int power(int a, int b) {
        if (b == 0 || a == 1) {
            return 1;
        }

        int half = power(a,b/2);
        if(b%2 == 0)
        {
            return half * half;
        }
        else{
            return half * half * a;
        }
    }
}
