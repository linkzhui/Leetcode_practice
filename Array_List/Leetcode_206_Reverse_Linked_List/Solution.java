package Google.Array_List.Leetcode_206_Reverse_Linked_List;

import Google.LinkedList.ListNode;

public class Solution {
    public ListNode reverseList(ListNode head) {
        //recursive way
        //1. at current level, we need to store next = cur.next
        //2. then keep call recursive method to pass next listnode to next level
        //3. after the return of the recursive function we come back to current level
        //4. we need to point the next.next to cur listnode
        //5. then we point the cur listnode to null
        if (head == null || head.next == null)
        {
            return head;
        }
        ListNode next = head.next;
        ListNode result = reverseList(next);
        next.next = head;
        head.next = null;
        return result;
    }

    public ListNode reverseList_iterative(ListNode head)
    {
        //iterative way
        //we need to store the next = cur.next;
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;
        while(cur!=null)
        {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
