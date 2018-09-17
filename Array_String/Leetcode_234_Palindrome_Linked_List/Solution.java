package Google.Array_String.Leetcode_234_Palindrome_Linked_List;

import Google.LinkedList.ListNode;

//Find the middle point, then reverse the second half, compare two linked list one by one,
//time O(n), space O(1)

public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
        {
            return true;
        }
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            //find the mid point of the linked list, the slow will stop in the middle point if the list length is event
            //or stop in the end point of left part
            fast = fast.next.next;
            slow = slow.next;
        }

        slow = slow.next;

        slow = reverse(slow);
        fast = head;

        while (slow != null) {
            if (fast.value != slow.value) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            //while current node is not null, we can keep reverse
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
