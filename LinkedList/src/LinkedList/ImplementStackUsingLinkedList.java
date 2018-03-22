package LinkedList;

/**
 * Created by Devaraj Reddy, 3/22/2018 - 11:47 PM
 */
public class ImplementStackUsingLinkedList {

    public static void main(String[] args) {

        System.out.println("Push elements to stack");
        LinkedStack linkedStack = new LinkedStack();
        linkedStack.push(123);
        linkedStack.push(234);
        linkedStack.push(678);
        linkedStack.push(789);
        System.out.println(linkedStack);

        System.out.println("Peek : "+linkedStack.peek());
        System.out.println("Size : "+linkedStack.size());

        System.out.println("Pop elements from stack");
        linkedStack.pop();
        linkedStack.pop();
        linkedStack.pop();
        System.out.println(linkedStack);

        System.out.println("Peek : "+linkedStack.peek());

        System.out.println("isEmpty : "+linkedStack.isEmpty());

        System.out.println("Size : "+linkedStack.size());

        System.out.println("Pop elements from stack");
        linkedStack.pop();
        linkedStack.pop();
        System.out.println("isEmpty : "+linkedStack.isEmpty());

        System.out.println("Size : "+linkedStack.size());
    }
}

class LinkedStack {
    Node head;

    LinkedStack() {
        head = null;
    }


    private void insertAtHead(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    private void deleteAtHead() {
        if (head != null) {
            head = head.next;
        }
    }

    public void push(int data) {
        insertAtHead(data);
    }

    public void pop() {
        if(isEmpty()){
            System.out.println("No elements to pop");
        }
        deleteAtHead();
    }

    public int peek() {
        if(isEmpty()){
            System.out.println("No elements to peek");
        }
        if (head != null)
            return head.data;
        else
            return -1;
    }

    public boolean isEmpty() {
        return head == null;
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

    @Override
    public String toString() {

        String result = "";
        Node tempNode = head;
        while(tempNode!=null){
            result = result + tempNode.toString()+"\n";
            tempNode=tempNode.next;
        }
        return result;
    }
}
