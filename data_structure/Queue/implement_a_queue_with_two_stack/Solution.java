package Google.data_structure.Queue.implement_a_queue_with_two_stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    //把所有的element从stack1 pop出来，push到另外一个stack2里，stack2 pop出来的顺序就是queue

}

class queue{
    // time complexity
    // push: O(1)
    // pop: O(n)
    Deque<Integer> stack_1 = new ArrayDeque<>();
    Deque<Integer> stack_2 = new ArrayDeque<>();
    public queue(){

    }
    public void offer_last(Integer input)
    {
        stack_1.offerLast(input);
    }
    public Integer poll_first()
    {
        if(stack_2.isEmpty()&&stack_1.isEmpty())
        {
            return null;
        }
        move();
        return stack_2.pollLast();
    }

    public int size()
    {
        return stack_1.size()+stack_2.size();
    }

    public Integer peek()
    {
        if(stack_2.isEmpty()&&stack_1.isEmpty())
        {
            return null;
        }
        move();
        return stack_2.peekLast();
    }

    void move(){
        if(stack_2.isEmpty()) {
            while (!stack_1.isEmpty()) {
                stack_2.offerLast(stack_1.pollLast());
            }
        }
    }
}
