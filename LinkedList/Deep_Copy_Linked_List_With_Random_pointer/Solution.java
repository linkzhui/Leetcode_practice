package Google.LinkedList.Deep_Copy_Linked_List_With_Random_pointer;

import java.util.HashMap;


//deep copy of LinkedList (node with next pointer and random pointer)
//hashmap: key: original node, value: copied node
//we need two nodes to track current node in two linkedlist, head node point to the current node in the original linkedlist, cur node point to the current node in the new linkedlist
//iterative the LinkedList, if we find current node is not exist in the hashmap, we put cur.next into hashmap and
public class Solution {
    public ListNode deepCopyLinkedListWithRandomPointer(ListNode head) {
        if (head == null) {
            return null;
        }
        HashMap<ListNode,ListNode> map = new HashMap<>();
        ListNode newHead = new ListNode(head.value);
        map.put(head,newHead);
        ListNode cur = newHead;
        while (head != null) {
            if (head.next!=null) {
              if (!map.containsKey(head.next)) {
                  //check if the random node is exist in the hashmap or not?
                  map.put(head.next,new ListNode(head.next.value));
              }
              //update copied node's next
              cur.next = map.get(head.next);
            }
            if (head.random != null) {
                if (!map.containsKey(head.random)) {
                    map.put(head.random, new ListNode(head.random.value));
                }
                //update copied node's random
                cur.random = map.get(head.random);
            }
            head = head.next;
            cur = cur.next;
        }
        return newHead;
    }

    private class ListNode{
        ListNode next;
        int value;
        ListNode random;
        public ListNode(int value) {
            this.value = value;
        }
    }
}
