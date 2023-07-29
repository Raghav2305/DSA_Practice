package Stacks_and_Queues;

public class Custom_QUEUE {
    int ptr = 0;
    protected int [] queue;
    private static final int size = 10;

    public Custom_QUEUE(int size) {
        this.queue = new int[size];
    }

    public Custom_QUEUE() {
        this(size);
    }

    public boolean isFull() {
        return ptr == queue.length ;
    }

    public boolean isEmpty(){
        return ptr == 0;
    }

    public boolean insert(int val) throws Exception{
        if(isFull()){
            throw new Exception("Cannot insert into a full Queue");
        }
        queue[ptr] = val;
        ptr++;
        return true;
    }

    public int remove() throws Exception{
        if(isEmpty()){
            throw new Exception("Cannot remove from empty queue");
        }

        int removed = queue[0];
        for (int i = 1; i < ptr; i++) {
            queue[i - 1] = queue[i];
        }
        ptr--;
        return removed;
    }
    
    public void display(){
        for (int i = 0; i < ptr; i++) {
            System.out.print(queue[i] + " <- ");
        }
        System.out.println("END");
    }
}
