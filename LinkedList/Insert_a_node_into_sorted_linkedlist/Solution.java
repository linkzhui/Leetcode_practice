package Google.LinkedList.Insert_a_node_into_sorted_linkedlist;

import Google.LinkedList.ListNode;
public class Solution {
    public static void main(String[] args)
    {
        ListNode head = new ListNode(0);
        ListNode cur = head;

        for(int i=1;i<=9;i+=2)
        {
            ListNode next = new ListNode(i);
            cur.next = next;
            cur = next;
        }
        Solution sol = new Solution();
        head = sol.insert_node(head,10);
        while(head!=null)
        {
            System.out.println(head.value);
            head = head.next;
        }
    }
    public ListNode insert_node(ListNode head, int target){
        ListNode new_node = new ListNode(target);
        if (head == null) {
            return new_node;
        }
        if (head.value <= target) {
            new_node.next = head;
            return new_node;
        }

        ListNode cur = head;
        while(cur.next != null && cur.next.value < target) {
            cur = cur.next;
        }

        new_node.next = cur.next;
        cur.next = new_node;
        return head;

    }
}
