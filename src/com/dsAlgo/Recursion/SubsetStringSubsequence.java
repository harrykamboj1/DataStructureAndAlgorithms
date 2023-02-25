package com.dsAlgo.Recursion;

import java.util.ArrayList;

public class SubsetStringSubsequence {
    public static void main(String[] args) {
        skip("","baccad");
        System.out.println(skip("bachgdcad"));
        System.out.println(skipApple("baccappledefs"));
        System.out.println(skipApp("dandfappvjsfn"));
        subSeq("","abc");
        System.out.println("");
        System.out.println(subSeqRet("","cba"));
        subSeqAscii("","ab");
        System.out.println("");
        System.out.println(subSeqRetAscii("","ab"));

    }
//    skip a particular character
    static void skip(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        if(ch == 'a'){
            skip(p, up.substring(1));
        }else{
            skip(p+ch, up.substring(1));
        }
    }
    static String skip(String up) {
        if (up.isEmpty()) {
            return "";
        }
        char ch = up.charAt(0);
        if (ch == 'a') {
            return skip(up.substring(1));
        }
            return ch + skip(up.substring(1));
    }
    //    skip a particular string
    static String skipApple(String up) {
        if (up.isEmpty()) {
            return "";
        }
        char ch = up.charAt(0);
        if (up.startsWith("apple")) {
            return skipApple(up.substring(5));
        }
        return ch + skipApple(up.substring(1));
    }
    //    skip a particular string that is not required
    static String skipApp(String up) {
        if (up.isEmpty()) {
            return "";
        }
        char ch = up.charAt(0);
        if (up.startsWith("app") && !up.startsWith("apple")) {
            return skipApp(up.substring(3));
        }
        return ch + skipApp(up.substring(1));
    }
//    creating subseuences
    static void subSeq(String p, String up){
        if(up.isEmpty()){
            System.out.print(p+" ");
            return;
        }
        char ch = up.charAt(0);
        subSeq(p+ch, up.substring(1));
        subSeq(p, up.substring(1));
    }
//    returning an arraylist of subsequences
    static ArrayList<String> subSeqRet (String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> left = subSeqRet(p+ch, up.substring(1));
        ArrayList<String> right = subSeqRet(p, up.substring(1));
        left.addAll(right);
        return left;
    }
//    printing  the ascii values
    static void subSeqAscii(String p, String up){
        if(up.isEmpty()){
             System.out.print(p+" ");
             return;
        }
        char ch = up.charAt(0);
        subSeqAscii(p+ch, up.substring(1));
        subSeqAscii(p, up.substring(1));
        subSeqAscii(p+(ch+0), up.substring(1));
    }
//   returning an arraylist of subsequences ascii
    static ArrayList<String> subSeqRetAscii (String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> left = subSeqRetAscii(p+ch, up.substring(1));
        ArrayList<String> right = subSeqRetAscii(p, up.substring(1));
        ArrayList<String> ascii = subSeqRetAscii(p+(ch+0), up.substring(1));
        left.addAll(right);
        left.addAll(ascii);
        return left;
    }
}
