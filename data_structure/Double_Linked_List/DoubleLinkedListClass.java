package Google.data_structure.Double_Linked_List;

public class DoubleLinkedListClass implements DoubleLinkedList{

    private Node head;
    private Node tail;
    private int size = 0;
    public DoubleLinkedListClass() {
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }

    @Override
    public boolean append(Node cur) {
        if(cur != null) {
            Node prev = tail.prev;
            prev.next = cur;
            cur.prev = prev;
            cur.next = tail;
            tail.prev = cur;
            size++;
        }
        return false;
    }

    public boolean insertAt(int index, Node node) {
        if (index >= size || index < 0) {
            return false;
        }
        int cur_index = 0;
        Node cur = head.next;
        while (cur_index < index) {
            cur = cur.next;
        }
        Node prev = cur.prev;
        prev.next = node;
        node.prev = prev;
        node.next = cur;
        cur.prev = node;
        return true;

    }

    @Override
    public boolean remove(Node cur) {
        if (cur != null) {
            Node prev = cur.prev;
            prev.next = cur.next;
            cur.next.prev = prev;
            size--;
            return true;
        }
        return false;

    }

    @Override
    public Node getHead() {
        return head.next;
    }

    public int size() {
        return size;
    }

    public class Node{
        Node prev;
        Node next;
        int val;
        public Node(int val) {
            this.val = val;
        }
    }
}
