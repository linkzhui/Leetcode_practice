package Google.Binary_search.find_cloest_element_in_array_to_target;

//how to find an element in the array that is closest to the target number?
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
        while(left+1<right)    //avoid the infinite loop，when left and right are neighbor
        {
            mid = left+(right-left)/2;
            if(array[mid]==target)
            {
                return mid;
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
