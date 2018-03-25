package LinkedList;

/**
 * Created by Devaraj Reddy, 3/24/2018 - 2:55 PM
 */
public class ReverseTheLinkedListInPairs {

    /*
     * 1,2,3,4,5,6,7,8
     * result : 2,1,4,3,6,5,8,7
     * */
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


        ReversePairLinkedList r = new ReversePairLinkedList();

        LinkedList reversedPairLinkedList = r.getReversedPairLinkedList(headNode);
        reversedPairLinkedList.display();


        LinkedList reversedPairLinkedList2 = r.getReversedPairLinkedListRecursion(headNode);
        reversedPairLinkedList2.display();

    }
}

class ReversePairLinkedList {

    // https://www.youtube.com/watch?v=jiLloHVmLDc
    public LinkedList getReversedPairLinkedList(Node headNode) {


        Node ptr = headNode;
        Node resultPtr = headNode.next;

        //if there is only one element.
        if(resultPtr==null){
            LinkedList linkedList = new LinkedList(ptr);
            return linkedList;
        }

        while (true) {

            Node ptrNext = ptr.next;
            Node temp = ptr.next.next;

            ptrNext.next = ptr;
            if (temp == null || temp.next == null) {
                ptr.next = temp;
                break;
            }

            ptr.next = temp.next;
            ptr = temp;

        }

        LinkedList linkedList = new LinkedList(resultPtr);
        return linkedList;
    }

    public LinkedList getReversedPairLinkedListRecursion(Node headNode) {


        Node node = recursiveMethod(headNode);


        LinkedList linkedList = new LinkedList(node);
        return linkedList;
    }

    private Node recursiveMethod(Node headNode) {

        if(headNode==null){
            return null;
        }

        if(headNode.next==null){
            return headNode;
        }

        Node temp = headNode.next;
        headNode.next=temp.next;
        temp.next=headNode;
        headNode=temp;

        headNode.next.next= recursiveMethod(headNode.next.next);
        return  headNode;
    }


}
