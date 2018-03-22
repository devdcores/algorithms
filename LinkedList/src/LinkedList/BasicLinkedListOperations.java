package LinkedList;

/**
 * Created by Devaraj Reddy, 3/22/2018 - 7:25 PM
 */
public class BasicLinkedListOperations {
    public static void main(String[] args) {

        LinkedList l = new LinkedList();
        l.insertAtHead(1);
        l.insertAtHead(2);

        l.display();

        l.insertAtTail(100);
        l.insertAtTail(200);

        l.display();
        System.out.println("Length 0f Linked List : "+l.size());

        l.insertAtPosition(6, 1000);
        l.display();

        System.out.println("Find at position 0 : "+l.findAtPosition(0));
        System.out.println("Find at position 3 : "+l.findAtPosition(2));
        System.out.println("Find at position 4 : "+l.findAtPosition(4));
        System.out.println("Find at position 7 : "+l.findAtPosition(7));

        l.deleteAtHead();

        l.display();

        l.deleteAtTail();
        l.deleteAtTail();
        l.deleteAtTail();
        l.deleteAtTail();
        l.deleteAtTail();


        l.display();
    }
}
