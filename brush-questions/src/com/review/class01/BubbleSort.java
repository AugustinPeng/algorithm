package com.review.class01;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //for test
    public static int[] sort(int[] arr){
        Arrays.sort(arr);
        return arr;
    }
    //for test
    public static boolean equals(int[] arr1, int[] arr2){
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("test begin");
        for (int i = 0; i < 1000; i++) {
            int[] arr = Logarithm.generateArr();
            int[] ints = Arrays.copyOf(arr, arr.length);
            int[] arr1 = bubbleSort(arr);
            int[] arr2 = sort(ints);
            if (!equals(arr1, arr2)){
                System.out.println("Fuck!!!");
                System.out.println(Arrays.toString(arr1));
                System.out.println(Arrays.toString(arr2));
                break;
            }
        }
        System.out.println("test finish");
    }
}
