package Google.Array_List.Leetcode_4_Median_of_Two_Sorted_Arrays;


//assume we split array 1 (0-m) into two parts at a random point (point i), we split array 2(0-n) into two parts at a random point(point j)
//array1(0-i, i+1-m),   array2(0-j,j+1-n)
//then we put array1(0-i) and array2(0-j) into one set, and put array1(i+1-n) and array2(j+1-m) into another set

//assume if length of set 1 and length of set 2 are equal and max(set 1) < min(set 2), then we have found the median

//to ensure this assumption, there are several constrain we should meet
//1. length of set 1 and length of set 2 are equal and according to the equation: i + j (left_part) = m-i+n-j (right_part)-> j = (m+n)/2 - i
//because 0<=i<=m, for j = (m+n)/2 - i, in order to make sure the j >=0, we need to make sure the m<=n;
//2. make sure B[j-1] <= A[i] and A[i-1] <= B[j]


//three condition:
//1. B[j-1]<=A[i] and A[i-1] <= B[j] : i found
//2. B[j-1]>A[i] : i+1
//3. A[i-1]>B[j]: i-1
public class Solution {
    public double findMedianSortedArrays(int[] A, int[] B)
    {

        if(A.length>B.length)
        {
            //make sure n<=m
            int[] temp = A;
            A = B;
            B = temp;
        }
        int m = A.length;
        int n = B.length;

        int iMin = 0, iMax = m, halfLen = (m+n+1)/2;
        while(iMin<=iMax)
        {
            int i = (iMax+iMin)/2;
            int j = halfLen-i;
            if(i<iMax && B[j-1] > A[i])
            {
                //because we want to increase i, need to make sure i still less than iMax
                iMin = iMin+1; //i is too small
            }
            else if(i>iMin && A[i-1]>B[j])
            {
                iMax = iMax - 1;
            }
            else{
                //B[j-1]<=A[i] and A[i-1] <= B[j]
                int maxLeft = 0;
                if(i==0)
                {
                    maxLeft = B[j-1];
                }
                else if(j==0)
                {
                    maxLeft = A[i-1];
                }
                else{
                    maxLeft=Math.max(A[i-1],B[j-1]);
                }
                if((m+n)%2==1)
                {
                    return maxLeft;
                }

                int minRight = 0;
                if(i == m)
                {
                    //which means j = 0
                    minRight = B[j];
                }
                else if(j==n)
                {
                    //which means i=0
                    minRight = A[i];
                }
                else {
                    minRight = Math.min(B[j],A[i]);
                }

                return (maxLeft+minRight)/2.0;
            }
        }
        return 0.0;
    }

}
