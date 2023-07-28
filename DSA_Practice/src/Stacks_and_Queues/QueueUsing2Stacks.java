package Stacks_and_Queues;

import java.util.Stack;

public class QueueUsing2Stacks {
    private Stack<Integer> stack;
    private Stack<Integer> helper;

    public QueueUsing2Stacks(){
        stack = new Stack<>();
        helper = new Stack<>();
    }

    public void insert(int item){

        stack.push(item);
    }

    public int remove() {

        while(!stack.isEmpty()){
            helper.push(stack.pop());
        }

        int removed = helper.pop();
        while(!helper.isEmpty()){
            stack.push(helper.pop());
        }
        return removed;
    }

    public int peek(){
        while(!stack.isEmpty()){
            helper.push(stack.pop());
        }
        int peeked = helper.peek();

        while(!helper.isEmpty()){
            stack.push(helper.pop());
        }
        return peeked;
    }


}


