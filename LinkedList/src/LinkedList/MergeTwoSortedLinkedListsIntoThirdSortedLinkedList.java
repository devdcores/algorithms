package LinkedList;

/**
 * Created by Devaraj Reddy, 3/24/2018 - 1:25 PM
 */
public class MergeTwoSortedLinkedListsIntoThirdSortedLinkedList {
    public static void main(String[] args) {

        //Create 1st chain os nodes
        Node headNode = new Node(123);
        Node node1 = new Node(234);
        headNode.next = node1;
        Node node2 = new Node(456);
        node1.next = node2;
        Node node3 = new Node(567);
        node2.next = node3;
        Node node4 = new Node(678);
        node3.next = node4;


        //create 2nd chain of nodes
        Node otherheadNode = new Node(345);
        Node othernode1 = new Node(375);
        otherheadNode.next = othernode1;
        Node othernode2 = new Node(500);
        othernode1.next = othernode2;
        Node othernode3 = new Node(600);
        othernode2.next = othernode3;
        Node othernode4 = new Node(650);
        othernode3.next = othernode4;
        Node othernode5 = new Node(700);
        othernode4.next = othernode5;
        Node othernode6 = new Node(800);
        othernode5.next = othernode6;
        Node othernode7 = new Node(900);
        othernode6.next = othernode7;

        LinkedList l1 = new LinkedList(headNode);
        LinkedList l2 = new LinkedList(otherheadNode);

        MergeLinkedLists mergeLinkedLists = new MergeLinkedLists();

        System.out.println("Efficient Way!!");
        LinkedList sortedThirdList = mergeLinkedLists.merge(l1, l2);
        sortedThirdList.display();

        System.out.println("Recursive Way!!");
        LinkedList sortedThirdListRecursion = mergeLinkedLists.mergeUsingRecursion(l1, l2);
        sortedThirdListRecursion.display();

    }
}

class MergeLinkedLists {


    /*
     * 11,22,33,44,55
     * 23,24,35,37,57,60
     *
     * */
    public LinkedList merge(LinkedList l1, LinkedList l2) {
        LinkedList sortedThirdList = new LinkedList();

        Node headOne = l1.head;
        Node headTwo = l2.head;


        while (headOne != null && headTwo != null) {

            if (headOne.data < headTwo.data) {
                sortedThirdList.insertAtTail(headOne.data);
                headOne = headOne.next;
            } else {
                sortedThirdList.insertAtTail(headTwo.data);
                headTwo = headTwo.next;
            }
        }

        if (headTwo == null) {
            while (headOne != null) {
                sortedThirdList.insertAtTail(headOne.data);
                headOne = headOne.next;
            }
        }

        if (headOne == null) {
            while (headTwo != null) {
                sortedThirdList.insertAtTail(headTwo.data);
                headTwo = headTwo.next;
            }
        }
        return sortedThirdList;
    }

    public LinkedList mergeUsingRecursion(LinkedList l1, LinkedList l2) {


        Node headOne = l1.head;
        Node headTwo = l2.head;

        Node node = mergeUsingRecursionNodes(headOne, headTwo);

        LinkedList sorted = new LinkedList(node);

        return sorted;
    }

    /*
     * 11,22
     * 23,24
     *
     * */
    private Node mergeUsingRecursionNodes(Node headOne, Node headTwo) {
        if (headOne == null) {
            return headTwo;
        }
        if (headTwo == null) {
            return headOne;
        }
        Node head;
        if (headOne.data < headTwo.data) {
            head=headOne;
            headOne.next=mergeUsingRecursionNodes(headOne.next,headTwo);
        }else{
            head= headTwo;
            headTwo.next=mergeUsingRecursionNodes(headOne, headTwo.next);
        }
        return head;
    }
}
