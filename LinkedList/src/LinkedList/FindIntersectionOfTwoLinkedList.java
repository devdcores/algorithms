package LinkedList;

import java.util.Stack;

/**
 * Created by Devaraj Reddy, 3/24/2018 - 1:34 AM
 */
public class FindIntersectionOfTwoLinkedList {
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


        //create 2nd chain of nodes
        Node otherheadNode = new Node(12345);
        Node othernode1 = new Node(23456);
        otherheadNode.next = othernode1;
        Node othernode2 = new Node(67890);
        othernode1.next = othernode2;
        Node othernode3 = new Node(78900);
        othernode2.next = othernode3;
        Node othernode4 = new Node(89000);
        othernode3.next = othernode4;
        Node othernode5 = new Node(90000);
        othernode4.next = othernode5;

        //Intersection point
        othernode5.next = node7;


        LinkedList linkOne = new LinkedList(headNode);
        LinkedList linkTwo = new LinkedList(otherheadNode);

        IntersectionOfLinkedLists intersectionOfLinkedLists = new IntersectionOfLinkedLists();
        System.out.println("Intersection Node Using Stack: " + intersectionOfLinkedLists.findIntersectionNodeUsingStack(linkOne, linkTwo));
        System.out.println("Intersection Node efficient Logic: " + intersectionOfLinkedLists.findIntersectionNodeEfficientLogic(linkOne, linkTwo));

    }
}

class IntersectionOfLinkedLists {
    LinkedList one;
    LinkedList two;

    IntersectionOfLinkedLists() {
    }

    Node findIntersectionNodeUsingStack(LinkedList linkOne, LinkedList linkTwo) {
        this.one = linkOne;
        this.two = linkTwo;
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        if (one != null) {
            Node head = one.head;
            while (head != null) {
                s1.push(head);
                head = head.next;
            }
        }

        if (two != null) {
            Node head = two.head;
            while (head != null) {
                s2.push(head);
                head = head.next;
            }
        }

        Node result = null;
        while (s1.peek() == s2.peek()) {
            result = s1.peek();
            s1.pop();
            s2.pop();
        }

        return result;
    }


    public Node findIntersectionNodeEfficientLogic(LinkedList linkOne, LinkedList linkTwo) {
        this.one = linkOne;
        this.two = linkTwo;

        int sizeOfOne = one.size();
        int sizeOfTwo = two.size();

        Node firstPointer = one.head;
        Node secondPointer = two.head;

        if (sizeOfOne > sizeOfTwo) {
            int diff = sizeOfOne - sizeOfTwo;
            int count = 0;
            while (firstPointer != null) {

                if (count == diff) {
                    break;
                }
                count++;
                firstPointer = firstPointer.next;
            }
        } else {
            int diff = sizeOfTwo - sizeOfOne;
            int count = 0;
            while (secondPointer != null) {
                count++;
                if (count == diff) {
                    break;
                }
                secondPointer = secondPointer.next;
            }
        }

        while (firstPointer != null && secondPointer != null) {
            if (firstPointer == secondPointer) {
                return firstPointer;
            }
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next;
        }

        return null;
    }
}
