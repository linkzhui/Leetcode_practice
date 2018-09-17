package Google.Array_String.Leetcode_11_Container_With_Most_Water;

//using two pointer, left pointer begin from index 0 and right pointer from end of the array,
//the rectangle area is: the minimum number of two pointer's height * distance between two pointers
//then we move the pointer with less height, cuz if we move the pointer, the length of the rectangle is decresing,
// therefore the best shot for us to find a bigger rectangle is to find a larger height.

public class Solution {
    public int maxArea(int[] height) {
        if(height==null || height.length==0)
        {
            return 0;
        }

        int max = 0;
        int left = 0;
        int right = height.length -1;
        while(left<right)
        {
            max = Math.max(max,Math.min(height[left],height[right])*(right-left));
            if(height[left]<=height[right])
            {
                left++;
            }
            else{
                right--;
            }
        }
        return max;
    }
}
