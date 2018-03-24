package LinkedList;

/**
 * Created by Devaraj Reddy, 3/24/2018 - 12:28 PM
 */
public class FindMidElementInLinkedList {
    public static void main(String[] args) {

        Node headNode = new Node(123);
        Node node1 = new Node(234);
        headNode.next = node1;
        Node node2 = new Node(1111);
        node1.next = node2;
        Node node3 = new Node(567);
        node2.next = node3;
        Node node4 = new Node(6666);
        node3.next = node4;
        Node node5 = new Node(789);
        node4.next = node5;
        Node node6 = new Node(444);
        node5.next = node6;
        Node node7 = new Node(2222);
        node6.next = node7;
        Node node8 = new Node(3333);
        node7.next = node8;
        Node node9 = new Node(4444);
        node8.next = node9;
//        Node node10 = new Node(7222);
//        node9.next = node10;

        MidElementLinkedList midElementLinkedList = new MidElementLinkedList();

        System.out.println("Middle node using size : " + midElementLinkedList.findMiddleElement(headNode));
        System.out.println("Middle node efficient method : " + midElementLinkedList.findMiddleElementEfficientMethod(headNode));
    }
}


class MidElementLinkedList {

    Node head;

    public Node findMiddleElement(Node head) {
        this.head = head;

        int mid = (int) Math.ceil((double) this.size() / 2);
        Node tempNode = head;
        int count = 1;
        while (tempNode != null) {
            if (count == mid) {
                return tempNode;
            }
            count++;
            tempNode = tempNode.next;
        }

        return null;
    }

    private int size() {
        int count = 0;
        Node tempNode = this.head;
        while (tempNode != null) {
            count++;
            tempNode = tempNode.next;
        }
        return count;
    }


    public Node findMiddleElementEfficientMethod(Node headNode) {
        Node slwPtr = headNode;
        Node ftrPtr = headNode;

        while (slwPtr != null && (ftrPtr != null && ftrPtr.next != null && ftrPtr.next.next != null)) {
            slwPtr = slwPtr.next;
            ftrPtr = ftrPtr.next.next;
        }
        return slwPtr;
    }
}
