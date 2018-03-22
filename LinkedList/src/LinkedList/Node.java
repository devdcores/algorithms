package LinkedList;

/**
 * Created by Devaraj Reddy, 3/22/2018 - 7:23 PM
 */
public class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}
