package com.review.class04;

/**
 *  在一个数组中，任何一个前面的数a，和任何一个后面的数b，如果(a,b)是降序的，就称为降序对
 *  给定一个数组arr，求数组的降序对总数量
 *
 *  和数组小和相同思路 归并排序
 */
public class ReversePair {

    public static int reversePairNumber(int[] arr){
        int N = arr.length;
        return process(arr, 0, N -1);
    }

    public static int process(int[] arr, int L, int R){
        if (L == R){
            return 0;
        }
        int mid = L + ((R -L) >> 1);
        return process(arr, L, mid) + process(arr, mid +1, R) + merge(arr, L, mid, R);
    }

    public static int merge(int[] arr, int L, int mid, int R){
        int[] help = new int[R -L +1];
        int index = 0;
        int num = 0;
        int p1 = L;
        int p2 = mid +1;
        while (p1 <= mid && p2 <= R){
            num += arr[p1] > arr[p2] ? p2 - mid : 0;
            help[index++] = arr[p1] > arr[p2] ? arr[p2++] : arr[p1++];
        }
        while (p1 <= mid){
            help[index++] = arr[p1++];
        }
        while (p2 <= R){
            help[index++] = arr[p2++];
        }
        for (int i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
        return num;
    }


    public static void main(String[] args) {

    }
}
