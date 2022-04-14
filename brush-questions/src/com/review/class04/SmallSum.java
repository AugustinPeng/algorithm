package com.review.class04;

/**
 *  返回数组小和
 *
 *  在一个数组中，一个数左边比它小的数的总和，叫该数的小和
 * 所有数的小和累加起来，叫数组小和
 * 例子： [1,3,4,2,5]
 * 1左边比1小的数：没有
 * 3左边比3小的数：1
 * 4左边比4小的数：1、3
 * 2左边比2小的数：1
 * 5左边比5小的数：1、3、4、 2
 * 所以数组的小和为1+1+3+1+1+3+4+2=16
 * 给定一个数组arr，求数组小和
 *
 *
 * 归并排序merge时产生小和
 */
public class SmallSum {


    public static int smallSum(int[] arr){
        int N = arr.length;
        return process(arr, 0, N-1);
    }

    public static int process(int[] arr, int L,int R){
        if (L == R){
            return 0;
        }
        int mid = L + ((R - L) >> 1);
        //排左边小和+右边小和+merge产生小和
        return process(arr, L, mid) + process(arr, mid +1, R) +  merge(arr, L ,mid, R);
    }

    public static int merge(int[] arr,int L,int mid,int R){
        int[] help = new int[R -L +1];
        int index = 0;
        int p1 = L;
        int p2 = mid +1;
        int res = 0;
        while (p1 <= mid && p2 <= R){
            res += arr[p1] < arr[p2] ? arr[p1] * (R - p2 + 1) : 0;
            help[index++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
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
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,4,2,5};
        int i = smallSum(arr);
        System.out.println(i);
    }
}
