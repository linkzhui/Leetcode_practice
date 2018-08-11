package Google.data_structure.Queue.sort_numbers_with_three_or_two_stacks;

import java.util.Deque;

//Question: sort numbers with three or two stacks
//把所有的数据都放在stack 1里面，然后stack 2放当前排好序的stack
//如果stack 2的peek（目前stack 2里面的最大值）比stack 1的peek要小，说明我们找到更小的值，需要插到stack2里面
//记录下来stack1的peek，记录为temp，同时poll出来
//把stack2的值持续poll到stack1里面，直到找到stack 2的peek值比temp要小
//把temp的值push回stack_2
public class Solution {
    void sort(Deque<Integer> stack_1,Deque<Integer> stack_2)
    {
        int temp;
        while(!stack_1.isEmpty())
        {
            if(stack_2.peekLast()>stack_1.peekLast())
            {
                temp = stack_2.pollLast();
                while(!stack_2.isEmpty()||temp>stack_2.peekLast())
                {
                    stack_1.offerLast(stack_2.pollLast());
                }
                stack_2.offerLast(temp);
            }
            else{
                stack_2.offerLast(stack_1.pollLast());
            }
        }
    }
}
