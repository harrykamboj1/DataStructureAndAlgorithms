package com.dsAlgo.StackAndQueue;

import java.util.Stack;

public class BalanceParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("(())"));
    }


    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        for (char it : s.toCharArray()) {
            if (it == '(' || it == '[' || it == '{')
                st.push(it);
            else {
                if(st.isEmpty()) return false;
                char ch = st.pop();
                if((it == ')' && ch == '(') ||  (it == ']' && ch == '[') || (it == '}' && ch == '{')) continue;
                else return false;
            }
        }
            return st.isEmpty();


    }
}
