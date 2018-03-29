package LinkedList;

/**
 * Created by Devaraj Reddy, 3/25/2018 - 11:21 PM
 */
public class ReverseTheLinkedListNodesByChunks {
    public static void main(String[] args) {
        Node headNode = new Node(1);
        Node node1 = new Node(2);
        headNode.next = node1;
        Node node2 = new Node(3);
        node1.next = node2;
        Node node3 = new Node(4);
        node2.next = node3;
        Node node4 = new Node(5);
        node3.next = node4;
        Node node5 = new Node(6);
        node4.next = node5;
        Node node6 = new Node(7);
        node5.next = node6;
        Node node7 = new Node(8);
        node6.next = node7;

        RevLinkedListByChunks r = new RevLinkedListByChunks();
        int chunkSize = 3;
        r.reversedLinkedListByChunks(chunkSize, headNode).display();


    }
}

class RevLinkedListByChunks {

    // 1 2 3 4 5 6 7 8
    public LinkedList reversedLinkedListByChunks(int chunkSize, Node head) {

        Node current = head;

        Node prevTail = null;

        Node prevCurrent = head;

        while (current != null) {
            int count = chunkSize;
            Node tail = null;
            while (current != null && count > 0) {
                Node next = current.next;
                current.next = tail;
                tail = current;
                current = next;
                count--;
            }


            if (prevTail != null) {
                prevTail.next = tail;
            } else {
                head = tail;
            }
            prevTail = prevCurrent;
            prevCurrent = current;
        }

        LinkedList l = new LinkedList(head);
        return l;
    }

}
