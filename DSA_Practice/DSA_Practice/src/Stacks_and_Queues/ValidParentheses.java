package Stacks_and_Queues;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int len = s.length();

        for (char ch: s.toCharArray())
              {
            if(ch == '{' || ch == '(' || ch == '['){
                stack.push(ch);
            }else{
                if(ch == '}'){
                    if(stack.isEmpty() || stack.pop() != '{'){
                        return false;
                    }
                }
                if(ch == ')'){
                    if(stack.isEmpty() || stack.pop() != '('){
                        return false;
                    }
                }
                if(ch == ']'){
                    if(stack.isEmpty() || stack.pop() != '['){
                        return false;
                    }
                }
            }

        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String str = "}";
        ValidParentheses obj = new ValidParentheses();
        System.out.println(obj.isValid(str));
    }
}
