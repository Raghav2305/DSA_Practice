package linked_list;

public class LL {
    private int size;
    private Node head;
    private Node tail;


    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public int deleteAtIndex(int index){
        if (index == 0){
            return deleteFirst();
        }else if(index == size){
            deleteLast();
        }

        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        int val = temp.next.value;
        temp.next = temp.next.next;
        size--;

        return val;
    }

    public int deleteLast(){
        if(size<=1){
            return deleteFirst();

        }

        Node temp = head;
        for (int i = 0; i < size - 2; i++) {
            temp = temp.next;
        }
        int val = tail.value;
        tail = temp;
        temp.next = null;


        size--;
        System.out.println(val);
        return val;

    }

    public int deleteFirst(){
        int num = head.value;
        head = head.next;

        size--;
        System.out.println(num);
        return num;
    }

    public void insertAtIndex(int val, int index){
        Node temp = head;
        for (int i = 1; i <= index - 1 ; i++) {
            temp = temp.next;
        }

        Node newNode = new Node(val);
        newNode.next = temp.next;
        temp.next = newNode;

        size++;
    }

    public void insertFirst(int value){
        Node node = new Node(value);
        node.next = head;
        head = node;
        if(tail == null){
            tail = head;
        }
        size+=1;
    }

    public void insertRec(int val, int index){
        head = insertRec(val, index, head);

    }

    private Node insertRec(int val, int index, Node node){
        if(index == 0){
            Node temp = new Node(val, node);
            size++;
            return temp;
        }

        node.next = insertRec(val, index--, node.next);
        return node;
    }

    public void insertLast(int value){
        if(tail == null){
            insertFirst(value);
            return;
        }
        Node node = new Node(value);
        tail.next = node;
        tail = node;
        size += 1;
    }

    private  class Node{
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
