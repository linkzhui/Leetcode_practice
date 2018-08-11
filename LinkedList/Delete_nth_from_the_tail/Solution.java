package Google.LinkedList.Delete_nth_from_the_tail;

import Google.LinkedList.ListNode;

//dummy -> 1 -> 2 -> 3 -> 4 -> null
//              s         f
public class Solution {
    public ListNode delete(ListNode head, int n)
    {
        ListNode dummy = new ListNode(100);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while(n>=0)
        {
            fast=fast.next;
            n--;
        }
        while(fast.next!=null)
        {
            fast=fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;

    }
}
