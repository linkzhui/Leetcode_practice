package Google.LinkedList.leetcode_25_Reverse_Nodes_in_k_groups;

import Google.LinkedList.ListNode;




public class Solution {
    public static void main(String[] args)
    {

    }

    //将每一组看成一个单独链表，记录其prev和next
    //当遍历完一组后，将此链表进行翻转，将这一组链表断开，并记录此链表翻转后的head和tail
    //        prev.next = head;
    //        tail.next = next;
    //将prev和cur后移
    //        prev = tail;
    //        cur = tail.next;


    public ListNode reverseKGroup_1(ListNode head, int k) {
        if (k == 1) {
           return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;

        int count = k;
        while (cur != null) {
            if (count == 1) {

                //断开中间需要reverse的部分
                //next prev
                ListNode h2 = prev.next;
                //next cur
                ListNode t2 = cur.next;
                prev.next = null;
                cur.next = null;

                //reverse the group of node
                ListNode newh = reverse(h2);
                prev.next = newh;
                h2.next = t2;

                //move reference
                prev = h2;
                cur = t2;
                count = k;
            } else {
                count--;
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    private ListNode reverse (ListNode root) {
        ListNode prev = null;
        ListNode cur = root;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    //   array: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7
    //   k = 4
    // step1: prev -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7
    // step2 (delete prev.next): prev -> 2 -> 3 -> 4 -> 5 -> 6 -> 7
    // step3: (insert prev.next into tail.next)

    //reverse linkedlist, 先接尾巴再接头
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
