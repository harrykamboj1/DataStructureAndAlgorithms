package com.dsAlgo.Array;

public class CyclicSort {

    public static void main(String[] args) {
        int arr[] = {2,4,3,5,1};
        cyclicSort(arr);
        System.out.println(arr);
    }

    public static void cyclicSort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int j = arr[i] - 1;
            if (i != j) {
                swap(arr, i, j);
            } else {
                i++;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
