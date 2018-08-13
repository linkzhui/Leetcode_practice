package Google.Binary_search.find_cloest_element_in_array_to_target;

//how to find an element in the array that is closest to the target number?

//提前停下来
public class Solution {
    public static void main(String[] args){
        int[] array = {1,2,5,8,9};
        Solution sol = new Solution();

    }

    int find_cloest_without_repeat(int[] array, int target)
    {
        if(array==null||array.length==0)
        {
            return -1;
        }
        int left = 0;
        int right = array.length-1;
        int mid = 0;
        while(left+1<right)    //when left and right are neighbor, terminate
        {
            mid = left+(right-left)/2;
            if(array[mid]==target)
            {
                return mid;       //cannot be mid + 1, because current value is still belong to our target solution,
                                    // the target solution must remain in the search space
            }
            else if(array[mid]<target)
            {
                left = mid;
            }
            else{
                right = mid;
            }
        }
        //post-processing, when the while loop end, we need to determine left or right is closest answer
        return (Math.abs(array[left]-target)>Math.abs(array[right]-target)? right:left);

    }
}
