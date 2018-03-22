package LinkedList;

/**
 * Created by Devaraj Reddy, 3/22/2018 - 7:25 PM
 */
public class BasicLinkedListOperations {
    public static void main(String[] args) {

        LinkedList l = new LinkedList();

        System.out.println("insert at head!!");
        l.insertAtHead(1);
        l.insertAtHead(2);
        l.display();

        System.out.println("insert at tail!!");
        l.insertAtTail(100);
        l.insertAtTail(200);
        l.display();

        System.out.println("Length 0f Linked List : "+l.size());

        System.out.println("insert at position 2!!");
        l.insertAtPosition(2, 1000);
        l.display();

        System.out.println("Find at position 0 : "+l.findAtPosition(0));
        System.out.println("Find at position 2 : "+l.findAtPosition(2));

        System.out.println("Delete at head!!");
        l.deleteAtHead();
        l.display();

        System.out.println("Delete at tail!!");
        l.deleteAtTail();
        l.display();

        System.out.println("Delete at position 2 !!");
        l.deleteAtPosition(1);
        l.display();
    }
}
