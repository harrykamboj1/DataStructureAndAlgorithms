package com.dsAlgo.StackAndQueue;

import java.util.Stack;

public class InfixToPrefix {
    public static void main(String[] args) throws Exception {
        String exp = "(p+q)*(m-n)";
        System.out.println("Infix expression: " + exp);
        System.out.println("Prefix expression: " + infixToPostfix(exp));
    }

    private static String infixToPostfix(String exp) throws Exception {
        // initializing empty String for result
        String result = new String("");
        try {
            // initializing empty stack
            Stack<Character> stack = new Stack();

            for (int i = 0; i < exp.length(); ++i) {
                char c = exp.charAt(i);
                // If the scanned character is an
                // operand, add it to output.
                if(Character.isLetterOrDigit(c)){
                    result += c;
                    // If the scanned character is an '(',
                    // push it to the stack.
                }else if(c=='('){
                    stack.push(c);
                }else if(c==')'){
                    while (!stack.isEmpty() && stack.peek()!='('){
                        result += stack.pop();
                    }
                    stack.pop();
                }else {
                    while (!stack.isEmpty() && Prec(c) <=
                            Prec(stack.peek())) {

                        result += stack.pop();
                    }
                    stack.push(c);
                }


                // pop all the operators from the stack

            }
            while (!stack.isEmpty()) {
                if (stack.peek() == '(')
                    return "Invalid Expression";
                result += stack.pop();
            }
            return result;


        } catch (Exception exception) {
            System.out.println("-----------" + exception.getLocalizedMessage() + "-------------");
        }
        return result;
    }

    static int Prec(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;

            case '^':
                return 3;

        }
      return -1;
    }
}
