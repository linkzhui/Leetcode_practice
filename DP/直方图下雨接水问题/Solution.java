package Google.DP.直方图下雨接水问题;

//Solution 1: 中心开花
//Solution 2: Similar to DP,
//Step1: scan from left to right to find M1[i]: represents highest level from 0 to i-th(include the i-th element)
//Step2: scan from right to left to find M2[i]: represents highest level from n-1 tp i-th(include the i-th element)
//Step3: sum+=Min(M1[i],M2[i]) - input[i]

//Solution3: 从两边开始扫描起，不管中间的，最左边和最右边是不能装水的，所以只有中间的部分可以装水，中间装水的量不能超过左右的最低点，
//然后向中间移动，两边的max，哪个小，移动哪个，因为只有移动小的，才能可能找到更高的边界
public class Solution {
    public void main(String[] args)
    {
        Solution sol = new Solution();
        int[] array  = {4,1,3,4,5,2,6};

        System.out.println(sol.find_max(array));
    }
    int find_max(int[] array)
    {
        //solution 2: DP solution
        //time complexity: O(n)
        //space complexity: O(n)
        int start = 0;
        int end = array.length-1;
        int[] M1 = new int[array.length];
        int[] M2 = new int[array.length];
        M1[0] = array[0];
        M2[array.length-1] = array[array.length-1];
        for(int i = 1;i<array.length;i++)
        {
            M1[i] = Math.max(M1[i-1],array[i]);
        }
        for(int i = array.length-2;i>=0;i--)
        {
            M2[i] = Math.max(M2[i+1],array[i]);
        }
        int sum = 0;
        for(int i = 0;i<array.length;i++)
        {
            sum+=Math.min(M1[i],M2[i])-array[i];
        }
        return sum;
    }

}


class Solution_3 {
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        int[] array  = {4,1,3,4,5,2,6};
        System.out.println(sol.find_max(array));
    }
    int sum_max(int[] array)
    {
        int start = 0;
        int end = array.length -1;
        int left_max = 0;
        int right_max = 0;
        int sum = 0;
        while(start<=end)
        {
            left_max = Math.max(left_max,array[start]);
            right_max = Math.max(right_max,array[end]);
            if(left_max<right_max)
            {
                sum+=left_max-array[start];
                start++;
            }
            else{
                sum+=right_max-array[end];
                end--;
            }
        }
        return sum;
    }
}