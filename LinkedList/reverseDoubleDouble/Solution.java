package Google.LinkedList.reverseDoubleDouble;


import Google.LinkedList.ListNode;

//链表 两两反转
//    1->2->3->4->5  to 2->1->4->3->5
//  p c  n  nn

//建立4个节点的reference
// previous，cur，next，nextNext
// prev.next = next;
//next.next = cur;
//cur.next = nextNext
//全部后移：  previous = current; current = current.next;
public class Solution {
    public ListNode reverse(ListNode head){
        ListNode dummy = new ListNode(100);
        ListNode cur = head;
        dummy.next = head;
        ListNode prev = dummy;
        while(cur!=null && cur.next!=null)
        {
            ListNode next = cur.next;
            ListNode nextNext = next.next;
            next.next = cur;
            cur.next = nextNext;
            prev.next = next;

            prev = cur;
            cur = nextNext;

        }
        return dummy.next;
    }
}
