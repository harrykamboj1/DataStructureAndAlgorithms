package com.dsAlgo.Recursion;


public class aToi {
    public static void main(String[] args) {

        System.out.println(myAtoi("words and 987"));
    }

    public static int myAtoi(String s) {
        int i = 0, n = s.length(), sign = 1;
        while (i < n && s.charAt(i) == ' ')
            ++i;

        if(i >= n)return 0;
        if (s.charAt(i) == '-') {
            sign = -1;
            ++i;
        }
        else if (s.charAt(i) == '+')
            ++i;

        return myAtoi(s, sign, i, 0);

    }

    static int myAtoi(String s, int sign, int i, int result) {


        if (i >= s.length() || s.charAt(i) < '0' || s.charAt(i) > '9')
            return sign * result;

        int tmp = s.charAt(i) - '0';
        if (result > Integer.MAX_VALUE / 10 || result == Integer.MAX_VALUE / 10 && tmp > 7)
            return sign > 0 ?Integer.MAX_VALUE: Integer.MIN_VALUE;

        return myAtoi(s, sign, i + 1, result * 10 + tmp);
    }
}
