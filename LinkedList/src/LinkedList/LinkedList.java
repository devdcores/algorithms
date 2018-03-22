package LinkedList;

/**
 * Created by Devaraj Reddy, 3/22/2018 - 7:24 PM
 */
public class LinkedList {
    Node head;

    LinkedList() {
        this.head = null;
    }

    public void insertAtHead(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    public void insertAtTail(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
        } else {
            Node tempNode = this.head;
            while (tempNode.next != null) {
                tempNode = tempNode.next;
            }
            tempNode.next = node;
        }
    }

    //if position doesnot exist, insert at the tail;
    public void insertAtPosition(int position, int data) {
        Node newNode = new Node(data);
        if (position == 0) {
            newNode.next=head;
            head=newNode;
        }else {
            Node tempNode = head;
            int count =0;
            while(tempNode.next!=null){
                count++;
                if(count==position){
                    break;
                }
                tempNode=tempNode.next;
            }
            Node nextNode = tempNode.next;
            tempNode.next=newNode;
            newNode.next=nextNode;
        }
    }

    public int findAtPosition(int position) {
        if (head == null) {
            return -1;
        } else {
            Node tempNode = head;
            int count = 0;
            while (tempNode != null) {
                if (count == position) {
                    return tempNode.data;
                }
                count++;
                tempNode = tempNode.next;
            }
        }
        return -1;
    }

    public int size() {
        int count = 0;
        Node tempNode = this.head;
        while (tempNode != null) {
            count++;
            tempNode = tempNode.next;
        }
        return count;
    }

    public void deleteAtHead(){
        if(head!=null){
            head=head.next;
        }
    }

    public void deleteAtTail(){
        if(head==null){
            return;
        }
        if(head.next == null){
            head=null;
            return;
        }
        Node tempNode = head;
        Node previousNode = head;
        while (tempNode.next!=null){
            previousNode=tempNode;
            tempNode=tempNode.next;
        }
        previousNode.next=null;

    }

    public void display() {
        System.out.println("***********************  Start Display  ********************************");
        Node node = this.head;
        while (node != null) {
            System.out.println("*        Current Node  :=============> " + node.data);
            if (node.next != null)
                System.out.println("*        Next node : " + node.next.data);
            else
                System.out.println("*        Next node : " + null);
            node = node.next;
        }
        System.out.println("***********************  End Display  **********************************");

    }
}
