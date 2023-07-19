package linked_list;


public class Doubly_LL {
    private int size;
    private Node head;
    private Node tail;

    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }



    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        if(head != null){
            head.prev = node;
        }
        head = node;

        if(tail == null){
            tail = head;
        }
        size++;
    }

    public void insertLast(int val){
        Node node = new Node(val);
        tail.next = node;
        tail = node;

        size++;
    }

    public void insertAtIndex(int val, int index){
        if(index == 0){
            insertFirst(val);
            return;
        }else if(index == size){
            insertLast(val);
            return;
        }
        Node node = new Node(val);
        Node temp = head;
        for (int i = 0; i < index -1; i++) {
            temp = temp.next;
        }

        node.next = temp.next;
        temp.next.prev = node;
        temp.next = node;
        node.prev = temp;


        size++;

    }

    private class Node{
        int val;
        Node next;
        Node prev;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        public Node(int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }
}
