package LinkedList;

/**
 * Created by Devaraj Reddy, 3/23/2018 - 10:11 PM
 */
public class InsertNodeInSortedLinkedList {
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
        Node node5 = new Node(789);
        node4.next = node5;

        Node node6 = new Node(1111);
        node5.next = node6;

        Node node7 = new Node(2222);
        node6.next = node7;

        Node node8 = new Node(3333);
        node7.next = node8;

        Node node9 = new Node(4444);
        node8.next = node9;

        SortedLinkedList sortedLinkedList = new SortedLinkedList(headNode);

        sortedLinkedList.display();
        sortedLinkedList.insertElement(888);
        sortedLinkedList.display();
    }
}

class SortedLinkedList {
    Node head;

    SortedLinkedList(Node head) {
        this.head = head;
    }

    public void insertElement(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        }

        Node tempNode = head;
        Node previousNode = null;
        while (tempNode != null) {

            if (tempNode.data > newNode.data) {
                break;
            }
            previousNode = tempNode;
            tempNode = tempNode.next;
        }

        if (previousNode == null) {
            newNode.next = head;
            head = newNode;
        } else {
            Node nextNode = previousNode.next;
            previousNode.next = newNode;
            newNode.next = nextNode;
        }

    }

    public void display() {
        System.out.println("***********************  Start Display  ********************************");
        System.out.println("");
        Node node = this.head;
        while (node != null) {
            System.out.print("" + node.data);
            if (node.next != null)
                System.out.print(" =======> ");
            else
                System.out.print(" =======> " + null);
            node = node.next;
        }
        System.out.println("");
        System.out.println("");
        System.out.println("***********************  End Display  **********************************");
        System.out.println("########################################################################");

    }
}