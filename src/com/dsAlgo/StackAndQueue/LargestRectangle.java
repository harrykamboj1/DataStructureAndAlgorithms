package com.dsAlgo.StackAndQueue;

import java.util.Stack;

public class LargestRectangle {
    public static void main(String[] args) {
//        System.out.println(largestArea(new int[]{
//                2,1,5,6,2,3
//        }));
        System.out.println(largestAreaOptimalSln(new int[]{
                2,1,5,6,2,3
        }));
    }

    // Brute Force Approach to find largest rectangle area in Histogram
    private static int largestArea(int[] heights) {
       int n = heights.length;
       int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int minHeight = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
               minHeight = Math.min(heights[j],minHeight);
               maxArea = Math.max(maxArea,minHeight*(j-i+1));
            }
        }
        return maxArea;
    }


    // Optimal Solution

    private static int largestAreaOptimalSln(int[] heights) {
        int n = heights.length;
        Stack < Integer > st = new Stack < > ();
        int leftSmall[] = new int[n];
        int rightSmall[] = new int[n];

        // To find Left Small at each index And Store in leftSmall Array
        for (int i = 0; i < n; i++) {
            // if element in stack is greater than the current height index remove that element.
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if (st.isEmpty()) leftSmall[i] = 0;
            else leftSmall[i] = st.peek() + 1;
            st.push(i);
        }

        // clear the stack to be re-used
        while (!st.isEmpty()) st.pop();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if (st.isEmpty()) rightSmall[i] = n - 1;
            else rightSmall[i] = st.peek() - 1;

            st.push(i);
        }

        int maxA = 0;
        for (int i = 0; i < n; i++) {
            maxA = Math.max(maxA, heights[i] * (rightSmall[i] - leftSmall[i] + 1));
        }
        return maxA;
    }
}
