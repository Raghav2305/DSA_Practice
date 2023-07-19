package linked_list;

public class Main {
    public static void main(String[] args) {
        LL list = new LL();

        list.insertFirst(2);
//        list.insertFirst(4);
//        list.insertFirst(3);
//        list.insertFirst(5);
        list.display();
        list.insertLast(6);
//        list.insertLast(8);
//        list.insertLast(9);
        list.display();
        list.insertAtIndex(10, 2);
//        list.insertAtIndex(12, 3);
//        list.insertAtIndex(15, 4);
        list.display();
        list.insertRec(995, 1);
        list.display();

    }
}
