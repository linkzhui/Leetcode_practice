package Google.Sort.Quick_sort;

import java.util.Arrays;

/**
 * Created by raymon on 7/6/17.
 */


public class Quicksort {
}




class quicksort_2{
    public void sort(int[] array)
    {
        if(array==null || array.length==0)
        {
            return;
        }

        quicksort_2(array,0,array.length-1);
    }

    public void quicksort_2(int[] array, int left, int right){

        //corner case
        if(left>=right)
        {
            return;
        }

        int pivot = partion(array,left,right);

        quicksort_2(array,left,pivot-1);
        quicksort_2(array,pivot+1,right);

    }

    public int partion(int[] array, int left, int right)
    {
        //choose the left one as the pivot number of the array
        int target = array[left];

        int index = left; //index of smaller element
        for(int i = index+1;i<=right;i++)
        {
            if(array[i]<=target)
            {
                ++index;
                swap(array, index, i);
            }

        }
        //swap the current index element with most left element
        swap(array,left,index);
        return index;



    }
    public void swap(int[] array, int left, int right)
    {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public static void main(String[] args){
        int[] array = {1,3,4,99,8,2,35,56,4,8,9,78};
        quicksort_2 solution = new quicksort_2();
        solution.sort(array);
        System.out.println(Arrays.toString(array));
    }
}

class quick_sort_3{
    public static void main(String[] args){
        int[] array = {1,3,4,99,8,2,35,56,4,8,9,78};
        quick_sort_3 solution = new quick_sort_3();
        solution.sort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }
    public void sort(int[] array,int start, int end){
        if(start>=end)
        {
            return;
        }
        int middle = start+(end-start)/2;
        int target = array[middle];
        int slow = start;
        swap(array,start,middle);
        for(int i = start+1;i<=end;i++)
        {
            if(array[i]<=target)
            {
                slow++;
                swap(array,slow,i);
            }
        }
        swap(array,slow,start);
        sort(array,start,slow-1);
        sort(array,slow+1,end);
    }
    private void swap(int[] array, int left, int right)
    {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;

    }

}