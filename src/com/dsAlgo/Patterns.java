package com.dsAlgo;

public class Patterns {
    public static void main(String[] args) {
        pattern1(5);
        pattern2(5);
        pattern3(5);
        pattern4(5);
    }

    static void pattern1(int n) {
        System.out.println("ist pattern is:-");
        for (int row = 1; row <= n; row++) {
            for(int col = 1; col<= n; col++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern2(int n) {
        System.out.println("2nd pattern is:-");
        for (int row = 1; row <= n; row++) {
            for(int col = 1; col<= row; col++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern3(int n) {
        System.out.println("3rd pattern is:-");
        for (int row = 1; row <= n; row++) {
            for(int col = 1; col<= n-row+1; col++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern4(int n) {
        System.out.println("4th pattern is:-");
        for (int row = 1; row <= n; row++) {
            for(int col = 1; col<= row; col++){
                System.out.print(col+" ");
            }
            System.out.println();
        }
    }
}
