package Google.DP.knapsack_problem;


//Question:
//w = 8
//weight[] = 4 3 5
//given a array of item's weight, and a capacity of bag


//base case: dp[0][0] = true; dp[0][1].....dp[0][m] = false
//induction rule: dp[i][w] = dp[i-1][w]||dp[i-1][w-weight[i]]
public class Q1 {
    public static void main(String[] args)
    {
        int[] array = {4,3,5};
        Q1 sol = new Q1();
        System.out.println(sol.get_max_weight(array,8));
    }
    int get_max_weight (int[] array, int capacity)
    {
        boolean[][] dp = new boolean[array.length+1][capacity+1];

        int max = 0;
        dp[0][0] = true;
        for(int i =1;i<=capacity;i++)
        {
            dp[0][i] = false;
        }
        for(int i = 1;i<=array.length;i++)
        {
            for(int j = 0;j<=capacity;j++)
            {
                dp[i][j] = dp[i-1][j]||(j-array[i-1]>=0 && dp[i-1][j-array[i-1]]);
                //be careful: capacity - array[i-1] -> if array[i-1] is less than current capacity, then wen cannot inherit
                // the previous result.
                if(dp[i][j])
                {
                    max = max>j? max:j;
                }

            }
        }
        return max;
    }
}


class Q1_1 {
    int get_max_weight(int[] array, int capacity)
    {
        if(array==null||array.length<=0||capacity<=0)
        {
            return 0;
        }
        boolean[] dp = new boolean[capacity+1];

        dp[0] = true;
        int max = 0;
        for(int i =1;i<=capacity;i++)
        {
            dp[i] = false;
        }

        boolean[] prev;
        for(int i = 1;i<=array.length;i++)
        {
            for(int j = capacity; j>=1;j--)
            {
                //填表格的规则，依赖j-array【i-1】，依赖他前面的元素，所以从右往左边填
                dp[j] = dp[j]||(dp[j-array[i-1]]&&j-array[i-1]>0);
                if(dp[j])
                {
                    Math.max(max,j);
                }
            }
        }
        return max;


    }
}