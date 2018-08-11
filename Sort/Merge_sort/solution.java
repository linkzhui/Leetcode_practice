package Google.Sort.Merge_sort;

import java.util.Arrays;



//time complexity: O(nlog(n))
/**
 * Created by raymon on 7/14/17.
 */
public class solution {
    public static void main(String[] args){
        solution sol = new solution();
        int[] array = {45,23,11,89,77,98,4,28,65,43};
        sol.merge_sort(array);
        System.out.println(Arrays.toString(array));
    }
    public void merge_sort(int[] array)
    {
        if(array.length == 0||array==null)
        {
            return;
        }
        partition(array,0,array.length-1);


    }

    public void partition(int[] array,int left, int right)
    {
        if(left<right)
        {
            int middle = (right-left)/2+ left;
            partition(array,left,middle);
            partition(array,middle+1,right);
            mergepart(array,left,middle,right);
        }
    }
    public void mergepart(int[] array,int left, int middle, int right) {
        int[] temp = new int[right - left + 1];

        int i = left;
        int j = middle + 1;
        int cur = 0;
        while (i <= middle && j <= right) {

           if (array[i] < array[j]) {
                temp[cur++] = array[i++]; //这里跑到J==right之后还是会j++就越界了，然后while loop就break了
            } else  if(array[i]>array[j]){
                temp[cur++] = array[j++];
            }
        }
        while(i<=middle)
        {
            temp[cur++] = array[i++];
        }
        while(j<=right)
        {
            temp[cur++] = array[j++];
        }
        int new_cur=0;
        for(int z =left;z<=right;z++)
        {
            array[z]=temp[new_cur++];
        }
    }

}
