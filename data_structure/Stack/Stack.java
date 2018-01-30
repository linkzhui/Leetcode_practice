package Google.data_structure.Stack;

/**
 * Created by raymon on 7/11/17.
 */

//using linked list to implement the stack
public class Stack {
    private int size;
    private ListNode head;
    public Stack(){
        this.size = 0;
        this.head = null;
    }

    public void push(int value){

        ListNode newnode = new ListNode(value);
        newnode.next = head;
        head = newnode;
        this.size++;
    }

    public Integer pull(){
        if(size == 0)
        {
            return null;
        }
        else{
            this.size--;
            int value = head.value;
            return value;
        }

    }

    public Integer peek(){
        if(this.size == 0)
        {
            return null;
        }
        else{
            return head.value;
        }
    }
}

class ListNode{
    int value;
    ListNode next;
    ListNode prev;
    public ListNode(int value)
    {
        this.value = value;
    }
}