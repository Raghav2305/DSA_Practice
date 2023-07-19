package Stacks_and_Queues;

public class Custom_Stack {
    int ptr = -1;
    protected int [] data;
    private static final int size = 10;

    public Custom_Stack(int size) {
        this.data = new int[size];
    }

    public Custom_Stack() {
        this(size);
    }

    public boolean push(int val) throws Exception{
        if(isFull()){
            throw new Exception("Cannot push in a full stack");
        }
        ptr++;
        data[ptr] = val;
        return true;
    }

    public int pop() throws Exception{
        if(isEmpty()){
            throw new Exception("Cannot pop from an empty stack");
        }

        int removed = data[ptr];
        ptr--;
        return removed;
    }

    public boolean isFull() {
        return ptr == data.length - 1;
    }

    public boolean isEmpty(){
        return ptr == -1;
    }
}
