package com.dsAlgo.StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

    public static void main(String[] args) {
        Stack1 s = new Stack1();
        s.push(3);
        s.push(2);
        s.push(4);
        s.push(1);
        System.out.println("Top of the stack: " + s.top());
        System.out.println("The deleted element is: " + s.pop());
        System.out.println("The Stack is empty or not : " + s.empty());
        System.out.println("Top of the stack after removing element: " + s.top());
    }

}

class Stack1 {

    Queue<Integer> queue = new LinkedList<>();

    public Stack1() {
    }

    public void push(int x) {
        queue.add(x);
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.peek());
            queue.remove();
        }
    }

    public int pop() {
        return queue.remove();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}