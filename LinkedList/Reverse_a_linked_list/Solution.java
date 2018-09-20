package Google.LinkedList.Reverse_a_linked_list;

public class Solution {
    public static void main(String[] args)
    {
        ListNode head = new ListNode(0);
        ListNode next = head;
        for(int i = 1;i<10;i++)
        {
            ListNode new_1 = new ListNode(i);
            next.next = new_1;
            next = new_1;
        }
        Solution sol = new Solution();
        head = sol.recursive_way(head);
        while(head!=null)
        {
            System.out.println(head.value);
            head = head.next;
        }


    }
    ListNode Interative_way(ListNode head){

        //need there dummy node, prev node, cur node and next node
        //the termination condition is when cur node is null
        //return prev node
        if(head == null)
        {
            return null;
        }
        ListNode prev = null;
        ListNode cur = head;
        while(cur!=null)
        {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    ListNode recursive_way(ListNode cur)
    {
        if(cur.next==null)
        {
            return cur;
        }
        ListNode next = cur.next;
        ListNode head = recursive_way(cur.next);
        next.next = cur;
        cur.next = null;
        return head;

    }
}

class ListNode {
    ListNode next;
    int value;
    public ListNode(int value)
    {
        this.value = value;
    }
}