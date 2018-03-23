package LinkedList;

/**
 * Created by Devaraj Reddy, 3/23/2018 - 8:14 PM
 */
public class FindLoopInLinkedList {
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

        //create a loop
        node9.next = node8;


        LoopInLinkedList loopInLinkedList = new LoopInLinkedList(headNode);

        System.out.println("isLoopExists : " + loopInLinkedList.isLoopExists());

        if (loopInLinkedList.isLoopExists()) {
            System.out.println("Find the starting point in the loop : " + loopInLinkedList.findTheStartingNodeInTheLoop());
        }
    }


}

class LoopInLinkedList {
    Node head;

    LoopInLinkedList(Node headNode) {
        this.head = headNode;
    }


    Node slwPtr;
    Node ftrPtr;

    public boolean isLoopExists() {
        if (this.head == null) {
            return false;
        }
        slwPtr = this.head;
        ftrPtr = this.head;
        while (slwPtr != null && ftrPtr.next != null) {
            slwPtr = slwPtr.next;
            ftrPtr = ftrPtr.next.next;
            if (slwPtr == ftrPtr) {
                return true;
            }
        }
        return false;
    }

    public Node findTheStartingNodeInTheLoop() {

        Node slwPtrLenth = slwPtr;
        Node ftrPointerLength = ftrPtr;
        int lengthOfLoop = 0;
        slwPtrLenth = slwPtrLenth.next;

        //TO find the length
        while (slwPtrLenth != ftrPointerLength) {
            lengthOfLoop++;
            slwPtrLenth=slwPtrLenth.next;
        }


        //To find the starting point of the loop
        slwPtr = head;
        while (!(slwPtr == ftrPtr)) {
            slwPtr = slwPtr.next;
            ftrPtr = ftrPtr.next;
        }

        System.out.println("Length of the loop : " + lengthOfLoop);
        return slwPtr;
        // return null;
    }
}