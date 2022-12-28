package com.dsAlgo.Recursion;

import java.util.ArrayList;

public class MazeProblem {
    public static void main(String[] args) {
        System.out.println(pathRet("",3,3));
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

    public static ArrayList<String> pathRet(String p, int r, int c){
        if(r==1 && c==1){
            ArrayList<String> newList = new ArrayList<>();
            newList.add(p);
            return newList;
        }


        ArrayList<String> list = new ArrayList<>();

        if(r>1){
            list.addAll(pathRet(p+'D',r-1,c));
        }
        if(c>1){
            list.addAll(pathRet(p+'R',r,c-1));
        }
        return list;
    }
}
