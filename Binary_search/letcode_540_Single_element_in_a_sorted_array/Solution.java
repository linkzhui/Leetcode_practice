package Google.Binary_search.letcode_540_Single_element_in_a_sorted_array;

//初始令左、右指针lo, hi分别指向0, len(nums) - 1
//当lo < hi时执行循环：
//令mi = (lo + hi) / 2
//若nums[mi] == nums[mi - 1]：
//数组可以分为[lo, mi - 2], [mi + 1, hi]两部分，目标元素位于长度为奇数的子数组中。
//同理，若nums[mi] == nums[mi + 1]：
//数组可以分为[lo, mi - 1], [mi + 2, hi]两部分，目标元素位于长度为奇数的子数组中。
//若nums[mi]与nums[mi - 1], nums[mi + 1]均不相等，则返回nums[mi]

public class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums == null || nums.length == 0)
        {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        while(start<end)
        {
            int mid = (start+end)/2;
            if(nums[mid] == nums[mid-1])
            {
                //0 -> mid -2 : odd length
                if((mid-1)%2 != 0)
                {
                    end = mid-2;
                }
                else{
                    start = mid + 1;
                }
            }
            else if(nums[mid] == nums[mid+1]){
                if(mid%2 != 0)
                {
                    end = mid - 1;
                }
                else{
                    start = mid + 2;
                }
            }
        }

        //这里return start或者end都可以，因为最后start和end会走到一起去
        return nums[start];
    }
}
