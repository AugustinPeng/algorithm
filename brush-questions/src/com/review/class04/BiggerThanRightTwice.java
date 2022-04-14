package com.review.class04;

/**
 * 在一个数组中，对于任何一个数num，求有多少个(后面的数*2)依然<num，返回总个数
 * 比如：[3,1,7,0,2]
 * 3的后面有：1，0
 * 1的后面有：0
 * 7的后面有：0，2
 * 0的后面没有
 * 2的后面没有
 * 所以总共有5个
 *
 */
public class BiggerThanRightTwice {

    public static int reversePairs(int[] arr){
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
        int windowR = mid + 1;
        int num = 0;
        for (int i = L; i <= mid; i++) {
            while (windowR <= R && arr[i] > arr[windowR] * 2){
                windowR++;
            }
            num += windowR - mid -1;
        }

        int[] help = new int[R -L +1];
        int index = 0;

        int p1 = L;
        int p2 = mid +1;
        while (p1 <= mid && p2 <= R){
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
        int[] arr = {1,3,2,3,1};
        int i = reversePairs(arr);
        System.out.println(i);
    }
}
