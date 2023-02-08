package com.dsAlgo.Recursion;

public class RecursionPractice {
//    printing name n times
    public static void main(String[] args) {
        printName(1,4);
        printNumbers(6);
        printOneToNUsingRecursion(1, 10);
        System.out.println(" ");
        printNToOneUsingRecursion(10,1);
        System.out.println(" ");
    }
    static void printName(int i,int n){
        if(i > n){
            return;
        }
        System.out.println("Bhavna");
        printName(i+1, n);
    }

//    print linearly 1 to n and n to 1 without recursion
    static void printNumbers(int n){
        for (int i = 1; i <= n; i++) {
            System.out.print(i +" ");
        }
        System.out.println(" ");
        for (int j = n; j > 0; j--) {
            System.out.print(j+" ");
        }
        System.out.println(" ");
    }
//    print linearly 1 to n with recursion
    static void printOneToNUsingRecursion(int i, int n){
        if(i>n){
            return;
        }
        System.out.print(i + " ");
        printOneToNUsingRecursion(i+1, n);
    }

    //    print linearly n to 1 with recursion
    static void printNToOneUsingRecursion(int n, int i){
        if(n<i){
            return;
        }
        System.out.print(n + " ");
        printNToOneUsingRecursion(n-1, i);
    }
}
