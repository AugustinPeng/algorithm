package com.review.sort;

import java.util.Arrays;

/**
 * 选择排序
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

    public static void main(String[] args) {
        int[] arr = {3, 25, 4, 4, 7, 6, 4, 96, 5};
        System.out.println(Arrays.toString(arr));
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
