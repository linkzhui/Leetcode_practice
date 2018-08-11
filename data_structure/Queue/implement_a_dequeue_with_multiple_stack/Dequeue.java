package Google.data_structure.Queue.implement_a_dequeue_with_multiple_stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Dequeue {
    //implement with two stacks
    //or we can use third stack to make stack1.size = stack2.size, when one of either stack's size is 0
    Deque<Enum> stack_1;
    Deque<Enum> stack_2;
    int size;
    public Dequeue(){
        this.size = 0;
        stack_1 = new ArrayDeque<>();
        stack_2 = new ArrayDeque<>();
    }

    public void offerFirst(Enum ele)
    {
        stack_2.offerLast(ele);
        size++;
    }

    public void offerLast(Enum ele)
    {
        stack_1.offerLast(ele);
        size++;
    }

    public Enum pollLast(){
        if(stack_1.isEmpty()&&stack_2.isEmpty())
        {
            return null;
        }
        move_stack(stack_1,stack_2);
        return stack_1.pollLast();
    }

    public Enum pollFirst(){
        if(stack_1.isEmpty()&&stack_2.isEmpty())
        {
            return null;
        }
        move_stack(stack_2,stack_1);
        return stack_2.pollLast();
    }

    public Enum peekFirst(){
        if(stack_1.isEmpty()&&stack_2.isEmpty())
        {
            return null;
        }
        move_stack(stack_2,stack_1);
        return stack_2.peekLast();
    }

    public Enum peekLast(){
        if(stack_1.isEmpty()&&stack_2.isEmpty())
        {
            return null;
        }
        move_stack(stack_1,stack_2);
        return stack_1.peekLast();
    }

    public boolean isEmpty()
    {
        return (size == 0);
    }


    private void move_stack(Deque<Enum> stack_1, Deque<Enum> stack_2){
        if(!stack_1.isEmpty())
        {
            size--;

        }
        else if(!stack_2.isEmpty())
        {
            while(stack_1.isEmpty())
            {
                stack_1.offerLast(stack_2.pollLast());
            }
            size--;

        }

    }

}
