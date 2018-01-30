package Google.data_structure.Queue;

/**
 * Created by raymon on 7/11/17.
 */

//Linkedlist 实现queue，插入在尾部插入，删除从头删除
public class Queue {
    ListNode head;
    ListNode tail;
    int size;
    public Queue(){

    }

    public void offer(int value)
    {
        ListNode node = new ListNode(value);
        if(size==0)
        {
            head = node;
            tail = head;

        }
        else{
            tail.next = node;
            tail = node;

        }
        size++;
    }

    public Integer poll(){
        if(size==0)
        {
            return null;
        }
        else{
            head = head.next;
            size--;
            if(head==null)
            {
                tail=null;
            }
            return head.value;
        }

    }
    public boolean isEmpty(){
        return size == 0;
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