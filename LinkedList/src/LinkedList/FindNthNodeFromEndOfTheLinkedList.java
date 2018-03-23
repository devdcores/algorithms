package LinkedList;

/**
 * Created by Devaraj Reddy, 3/23/2018 - 6:21 PM
 */
public class FindNthNodeFromEndOfTheLinkedList {
    public static void main(String[] args) {

        Node headNode = new Node(123);
        Node node1 = new Node(234);
        headNode.next = node1;
        Node node2 = new Node(456);
        node1.next = node2;
        Node node3 = new Node(567);
        node2.next = node3;
        Node node4 = new Node(678);
        node3.next = node4;

        NthNodeFromEnd nthNodeFromEnd = new NthNodeFromEnd(headNode);

        Node nthFromEndOfLinkedList = nthNodeFromEnd.findNthFromEndOfLinkedList(2);
        System.out.println("Result Optimized : " + nthFromEndOfLinkedList);

        System.out.println("Result Regular : " + nthNodeFromEnd.findNthFromEndOfLinkedListRegular(2));
    }
}


/*
 *  123  --> 234 --> 456 --> 567 --> 678
 *  position = 2
 *  result = 567
 *
 *
 * Logic : use two pointers at the beginning pTemp, pNthNode, move ptemp for n steps,
 * then move both the pointers stop when ptemp points to null, return pNth.
 *
 * */
class NthNodeFromEnd {

    Node head;

    NthNodeFromEnd(Node head) {
        this.head = head;
    }


    //optimized solution, time : o(n), space : o(1)
    public Node findNthFromEndOfLinkedList(int position) {

        Node pTemp = this.head;
        Node pNthNode = null;

        for (int count = 0; count < position; count++) {
            if (pTemp != null) {
                pTemp = pTemp.next;
            }
        }

        while (pTemp != null) {
            if (pNthNode == null) {
                pNthNode = this.head;
            }
            pTemp = pTemp.next;
            pNthNode = pNthNode.next;
        }

        return pNthNode;
    }

    public Node findNthFromEndOfLinkedListRegular(int position) {

        int found = this.size() - position + 1;
        int count = 0;
        Node tempNode = this.head;
        while (tempNode != null) {
            count++;
            if (count == found) {
                return tempNode;
            }
            tempNode = tempNode.next;
        }
        return null;
    }

    private int size() {
        int result = 0;
        Node tempNode = this.head;
        while (tempNode != null) {
            result++;
            tempNode = tempNode.next;
        }
        return result;
    }
}
