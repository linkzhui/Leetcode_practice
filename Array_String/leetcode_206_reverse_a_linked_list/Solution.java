package Google.Line.leetcode_206_reverse_a_linked_list;


public class Solution {

    public ListNode reverse_iterator(ListNode head){
        //use prev to save the prev node
        //save the head.next to temp
        //then the cur.next point to prev
        //update the prev to cur

        ListNode prev = null;
        ListNode temp;
        while(head!=null)
        {
            temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;

        //time complex is O(N)
        //space is O(1)
    }

    public ListNode reverse_recursion(ListNode head)
    {

        //going to the tail of the linkedlist first
        //save the current node as prev and save current_node.next as next
        //then return the tail as new head
        //point the next.next = prev

        while(head==null||head.next==null)
        {
            return head;
        }
        ListNode prev = head;
        ListNode next = head.next;
        head=reverse_recursion(next);
        next.next = prev;
        prev.next=null; //这里要注意，不做的话，走到原来的头，原来的头的next就不是null了
        return head;

        //the time_complex is O(N)
        //the space is O(N), because each stack need 2 extra space to save the prev and next node.
    }

}

class ListNode{
    ListNode next;
    int value;
    ListNode(int _value)
    {
        value = _value;
    }
}
