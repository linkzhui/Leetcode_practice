package Google.LinkedList.merge_two_sorted_linkedlist_into_one_linkedlist;

import Google.LinkedList.ListNode;
public class Solution {
    public ListNode sort_two_Linked(ListNode head1, ListNode head2)
    {
        if(head1==null || head2 == null)
        {
            return head1 == null? head2: head1;
        }
        ListNode new_head = new ListNode(10);
        ListNode cur = new_head;
        while(head1!=null && head2!=null)
        {

            if(head1.value<head2.value)
            {
                cur.next = head1;
                head1=head1.next;
                cur = cur.next;
            }
            else{
                cur.next = head2;
                head2 = head2.next;
                cur = cur.next;
            }
        }
        if(head1==null)
        {
            cur.next = head2;
        }
        else{
            cur.next = head1;
        }
        return new_head.next;
    }
}
