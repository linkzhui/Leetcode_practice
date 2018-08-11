package Google.Tree.print_all_combinations_of_coins_that_can_sum_up_to_a_total_value_k;

import java.util.LinkedList;

/**
 * Created by raymon on 7/16/17.
 */
public class Solution {
    public static void main(String[] args)
    {
        
    }
    public void sum(int[] array,int money_left,LinkedList<Integer> temp,LinkedList<LinkedList<Integer>> result) {
        if(money_left==0)
        {
            return;
        }
        for (int i = 0; i < array.length; i++)
        {
            int temp_value = array[i];
            for(int j = 0;j*temp_value<=money_left;j++)
            {
                for(int z = 0;z<=j;z++)
                {
                    temp.add(temp_value);
                }
                sum(array,money_left/(j*temp_value),temp,result);
            }
        }
    }
}
