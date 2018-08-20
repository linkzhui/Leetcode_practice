package Google.LinkedList.Leetcode_203_Remove_linkedList_elements;

import Google.LinkedList.ListNode;

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null)
        {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        dummy.next = head;
        ListNode cur = head;
        while(cur!=null) {
            if (cur.value == val)
            {
                //trick part: cur node is removed, therefore the prev node does not change
                prev.next = cur.next;
            }
            else{
                prev = prev.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
