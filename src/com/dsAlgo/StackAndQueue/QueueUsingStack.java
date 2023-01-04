package com.dsAlgo.StackAndQueue;

import java.util.Stack;

public class QueueUsingStack {
    public static void main(String[] args) {

    }
}

class MyQueue{

    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();

    public MyQueue() { }

    public void push(int x){
        input.push(x);
    }

    public int pop(){
            if(output.isEmpty()){
                while (!input.empty()){
                    output.push(input.peek());
                    input.pop();
                }

            }

            int x = output.peek();
            output.pop();
            return x;
        }

    public int peek(){
        if (output.empty())
            while (!input.empty()) {
                output.push(input.peek());
                input.pop();
            }
        return output.peek();
    }
    public boolean empty() {
        if(input.size() == 1){
            return false;
        }
       return output.isEmpty();
    }

}
