package Stacks_and_Queues;

public class Main {
    public static void main(String[] args) throws Exception{
        Custom_Stack stack1 = new Dynamic_Stack(6);
        stack1.push(5);
        stack1.push(19);
        stack1.push(37);
        stack1.push(44);
        stack1.push(7);
        stack1.push(7);
        stack1.push(7);

        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
    }

}
