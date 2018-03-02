package Google.Array_List.Leetcode_2_Add_Two_NUmbers;

//1. when we add two integers, we always begin the addition from the least-significant digit
//2. the list is already reversed order, therefore the least-significant digit is the head of the list
//then we just iterator go through the whole list

//Follow up: if the list order is not reversed, then we need to reverse two list first, then we can perform the addition after.

public class Leetcode_2_Add_Two_Numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        int carryOn = 0;
        ListNode dummyHead = new ListNode(123);
        ListNode cur = dummyHead;
        int first = 0;
        int second = 0;
        while(l1!=null||l2!=null)
        {
            first = l1 == null? 0:l1.val;
            second = l2 == null? 0:l2.val;
            int sum = first+second+carryOn;
            int reminder = sum%10;
            carryOn = sum/10;
            cur.next = new ListNode(reminder);
            cur = cur.next;
            l1 = l1 == null? l1:l1.next;
            l2 = l2 == null? l2:l2.next;
        }
        if(carryOn==1)
        {
            cur.next = new ListNode(1);
        }

        return dummyHead.next;


    }

//    private ListNode reverse(ListNode l1)
//    {
//        if(l1==null)
//        {
//            return l1;
//        }
//        ListNode cur = l1;
//        ListNode prev = null;
//        ListNode next = l1.next;
//        while(cur!=null)
//        {
//            next = cur.next;
//            cur.next = prev;
//            prev = cur;
//            cur = next;
//        }
//        return prev;
//    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int x)
    {
        val = x;
    }
}
