package Stacks_and_Queues;

public class CircularQueue {
    int head = 0;
    int tail = 0;
    int length = 0;
    protected int [] queue;
    private static final int size = 6;

    public CircularQueue(int size) {
        this.queue = new int[size];
    }

    public CircularQueue() {
        this(size);
    }

    public boolean isFull() {
        return length == queue.length ;
    }

    public boolean isEmpty(){
        return length == 0 ;
    }

    public boolean insert(int val) throws  Exception{
        if(isFull()){
            throw new Exception("Cannot insert into a full Queue");
        }

        queue[tail++] = val;
        tail = tail % queue.length;
        length++;
        return true;
    }

    public int remove() throws Exception{
        if(isEmpty()){
            throw new Exception("Cannot remove from an empty queue");
        }
        int removed = queue[head++];

        head = head % queue.length;
        length--;
        return removed;
    }

    public void display(){
        if(isEmpty()){
            System.out.println("Empty!!!");
            return;
        }
        int i = head;
        do{
            System.out.print(queue[i] + " -> ");
            i++;
            i %= queue.length;
        }while (i != tail);
        System.out.println("END");
    }

}
