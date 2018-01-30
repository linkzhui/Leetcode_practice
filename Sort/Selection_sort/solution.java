package Google.Sort.Selection_sort;

import java.util.Arrays;

/**
 * Created by raymon on 7/14/17.
 */
public class solution {
    public void selection_sort(int[] array)
    {
        if(array.length==0||array==null)
        {
            return;
        }
        int min = 10000;
        for(int i =0;i<array.length;i++)
        {

            int index = i;
            for(int j = i;j<array.length;j++)
            {
                if(array[j]<min)
                {
                    min = array[j];
                    index = j;
                }
            }
            swap(array,i,index);
        }

    }

    public void swap(int[] array, int left, int right)
    {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public static void main(String[] args){
        int[] array = {-1,-3,4,7};
        solution sol = new solution();
        sol.selection_sort(array);
        System.out.println(Arrays.toString(array));
    }
}
