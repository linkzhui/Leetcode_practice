package Google.Array_String.Leetcode_21_Merge_Two_Sorted_Lists;

import Google.LinkedList.ListNode;

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null)
        {
            return l1 == null? l2:l1;
        }
        ListNode dummyHead = new ListNode(123);
        ListNode cur = dummyHead;
        while(l1!=null&&l2!=null)
        {
            if(l1.value<=l2.value)
            {
                cur.next = new ListNode(l1.value);
                l1 = l1.next;
                cur = cur.next;
            }
            else{
                cur.next = new ListNode(l2.value);
                l2 = l2.next;
                cur = cur.next;
            }
        }
        if(l1!=null)
        {
            cur.next = l1;
        }
        else if(l2!=null)
        {
            cur.next = l2;
        }
        return dummyHead.next;
    }
}
