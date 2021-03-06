package com.review.class01;

import java.util.Arrays;

/**
 * ιζ©ζεΊ
 */
public class SelectSort {

    public static int[] selectSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            swap(arr, i ,minIndex);
        }
        return arr;
    }

    public static void swap(int[] arr, int i ,int j){
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
            int[] test1 = Logarithm.generateArr();
            int[] test2 = Arrays.copyOf(test1, test1.length);
            int[] arr1 = selectSort(test1);
            int[] arr2 = sort(test2);
            if (!equals(arr1, arr2)){
                System.out.println("FUCK!!!");
                System.out.println(Arrays.toString(arr1));
                System.out.println(Arrays.toString(arr2));
                break;
            }
        }
        System.out.println("test finish");

    }
}
