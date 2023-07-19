package Stacks_and_Queues;

public class QueueUsing2StacksMain {
    public static void main(String[] args) throws Exception {
        QueueUsing2Stacks my_Q = new QueueUsing2Stacks();
        my_Q.insert(51);
        my_Q.insert(52);
        my_Q.insert(53);
        my_Q.insert(55);
        my_Q.insert(56);
        System.out.println(my_Q.peek());
        System.out.println(my_Q.remove());
        System.out.println(my_Q.remove());
        System.out.println(my_Q.peek());
    }
}
