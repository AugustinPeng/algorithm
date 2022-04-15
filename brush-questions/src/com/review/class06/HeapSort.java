package com.review.class06;

import com.review.class01.Logarithm;

import java.util.Arrays;

/**
 * 堆排序实现
 */
public class HeapSort {

    public static void heapSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        MyHeap heap = new MyHeap(arr.length);
        for (int i = 0; i < arr.length; i++) {
            heap.push(arr[i]);
        }
        for (int i = arr.length -1; i >=0 ; i--) {
            arr[i] = heap.pop();
        }
    }

    public static void main(String[] args) {
        int[] arr = Logarithm.generateArr();
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
