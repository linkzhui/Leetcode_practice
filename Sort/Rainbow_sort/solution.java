package Google.Sort.Rainbow_sort;

import java.util.Arrays;

/**
 * Created by raymon on 7/14/17.
 */
public class solution {
    public void rainbow_sort(int[] array)
    {
        if(array.length==0||array==null)
        {
            return;
        }

        int left_index = 0; //(0->i) = a
        int cur = 0;        //(i->j) = b
        int right_index = array.length-1;  //(j->k) = c
        while(cur<=right_index)  //这里要用到等于，因为right_index有可能从来没有被走过
        {
            if(array[cur]==1)
            {
                swap(array,left_index,cur);
                cur++;
                left_index++;
            }
            else if(array[cur]==2)
            {
                cur++;
            }else{
                swap(array,cur,right_index);
                right_index--;
            }
        }
    }


    public void rainbow_sort_1(int[] array)
    {
        if(array == null || array.length==0)
        {
            return;
        }
        int left_index =-1;
        int right_index = array.length;
        int cur = 0;
        while(cur<right_index)
        {
            if(array[cur]==1)
            {
                swap(array,++left_index,cur);
                cur++;
            }
            else if(array[cur]==2)
            {
                cur++;
            }
            else
            {
                swap(array,--right_index,cur);

            }
        }
    }

    public void swap(int[] array, int left, int right)
    {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public static void main(String[] args)
    {
        solution sol = new solution();
        int[] array = {2,3,1};
        sol.rainbow_sort_1(array);
        System.out.println(Arrays.toString(array));

    }
}
