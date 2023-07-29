package Stacks_and_Queues;

public class QueueMain {
    public static void main(String[] args) throws Exception {
        CircularQueue queue1 = new CircularQueue();
        queue1.insert(5);
        queue1.insert(7);
        queue1.insert(8);
        queue1.insert(98);
        queue1.insert(12);
        queue1.insert(65);
        queue1.display();
        queue1.remove();
        queue1.remove();
        queue1.display();
        queue1.insert(20);
        queue1.insert(29);
        queue1.display();

    }
}
