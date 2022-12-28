package com.dsAlgo.Recursion;

public class MazeProblem {
    public static void main(String[] args) {
        path("",3,3);
    }


    // Step count to reach at position
    public static int count(int r,int c){
        if(r==1 || c==1){
            return 1;
        }

        int left = count(r-1,c);
        int right = count(r,c-1);

        return left+right;
    }

    public static void path(String p,int r,int c){
        if(r==1 && c==1){
            System.out.println(p);
            return;
        }

        if(r>1){
            path(p+'D',r-1,c);
        }
        if(c>1){
            path(p+'R',r,c-1);
        }
    }
}
