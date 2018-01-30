package Google.LinkedList.Determine_a_loop_exist_or_not;

import Google.LinkedList.ListNode;

public class Solution {
    public boolean circle (ListNode head)
    {
        if(head == null || head.next == null)
        {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
            {
                return true;
            }
        }
        return false;
    }
}
