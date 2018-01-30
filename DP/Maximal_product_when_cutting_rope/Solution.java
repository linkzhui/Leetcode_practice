package Google.DP.Maximal_product_when_cutting_rope;

//Question: Given a rope with integer-length n, how to cut the rope into m
//integer-length parts with length P[0],P[1]...P[m-1]
//inorder to get the maximal product of P[0]*p[1]...p[m-1]


//                  左大段         右小段
//M[5] =    case 1: max(4,M[4]) * 1
//          case 2: max(3,M[3]) * 2
//          case 3: max(2,M[2]) * 3
//          case 4: max(1,M[1]) * 4

public class Solution {
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        System.out.println(sol.max_product(10));
    }
    int max_product(int s) {

        if (0 <= s && s <= 2) {
            return 1;
        }
        int[] dp = new int[s + 1];
        for (int i = 0; i <= 2; i++) {
            dp[i] = 1;
        }

        for (int i = 3; i <= s; i++)
        {
            int max =1;
            //i represents the cur length

            for(int j = 1;j<i;j++)
            {
                //j represents 左大段
                max = Math.max(max,Math.max(j,dp[j])*(i-j));
            }
            dp[i] = max;
        }
        return dp[s];
    }
}
