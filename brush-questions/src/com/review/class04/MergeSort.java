package com.review.class04;

import com.review.class01.Logarithm;

import java.util.Arrays;

/**
 *  归并排序 递归和非递归版本
 */
public class MergeSort {

    public static void mergeSort1(int[] arr){
        int N = arr.length;
        if (arr == null || N < 2){
            return;
        }
        process1(arr, 0, N -1);
    }

    public static void process1(int[] arr, int L, int R){
        if (L == R){
            return;
        }
        int mid = L + (R - L) / 2;
        process1(arr, L, mid);
        process1(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int mid, int R){
        int[] help = new int[R - L + 1];
        int hi = 0;
        int p1 = L;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= R){
            help[hi++] = arr[p1] > arr[p2] ? arr[p2++] : arr[p1++];
        }
        while (p1 <= mid){
            help[hi++] = arr[p1++];
        }
        while (p2 <= R){
            help[hi++] = arr[p2++];
        }
        for (int i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }


    public static void main(String[] args) {
        int[] arr = Logarithm.generateArr();
        System.out.println(Arrays.toString(arr));
        mergeSort1(arr);
        System.out.println(Arrays.toString(arr));
    }
}
