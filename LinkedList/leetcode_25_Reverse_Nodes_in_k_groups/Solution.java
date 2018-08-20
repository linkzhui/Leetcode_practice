package Google.LinkedList.leetcode_25_Reverse_Nodes_in_k_groups;

import Google.LinkedList.ListNode;


//   array: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7
//   k = 4
// step1: prev -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7
// step2 (delete prev.next): prev -> 2 -> 3 -> 4 -> 5 -> 6 -> 7
// step3: (insert prev.next into tail.next)

//reverse linkedlist, 先接尾巴再接头
public class Solution {
    public static void main(String[] args)
    {

    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k<2)
        {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        dummy.next = head;
        ListNode prev = dummy;
        ListNode temp;
        int count;
        while(true) {
            count = k;
            while (tail != null && count > 0) {
                tail = tail.next;
                count--;
            }

            if (tail == null) {
                break;
            }

            head = prev.next;
            while (prev.next != tail)
            {
                temp = prev.next;
                prev.next = temp.next;
                temp.next = tail.next;
                tail.next = temp;
            }

            tail = head;
            prev = head;
        }
        return dummy.next;
    }
}
