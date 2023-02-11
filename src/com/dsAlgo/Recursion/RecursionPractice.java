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
        System.out.println(product(4));
        System.out.println(fact(5));
        System.out.println(sumWithoutRecursion(10));
        System.out.println(sum(10));
        System.out.println(sumOfDigits(23401));
        System.out.println(productOfDigits(2312));
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
//    product of n to 1
    static int product(int n){
        int product = 1;
        for (int i = 1; i <=n; i++) {
            product*= i;
        }
        return product;
    }
    static int fact(int n){
        if(n <=1){
            return 1;
        }
        return n*fact(n-1);
    }
//    sum of first n numbers
    static int sumWithoutRecursion(int n){
        int sum = 0;
        for(int i = 1; i <=n; i++){
            sum+= i;
        }
        return sum;
    }
    static int sum(int n){
        if(n ==0){
            return 0;
        }
        return n+sum(n-1);
    }
//    sum of digits
    static int sumOfDigits(int n){
        if(n==0){
            return 0;
        }
        return (n%10) + sumOfDigits(n/10);
    }
//    product of digits
    static int productOfDigits(int n){
        if(n%10 == n){
            return n;
        }
        return (n%10)*productOfDigits(n/10);
    }
}
