package com.review.class05;

/**
 *  快排演变
 */
public class PartitionAndQuickSort {

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //荷兰国旗问题
    //小于target放左边等于target放中间大于target放右边
    public static void DutchFlag(int[] arr, int target){

    }

    //partition过程
    public static int[] partition(int[] arr, int L, int R){
        if (L == R){
            return new int[]{-1,-1};
        }
        int target = arr[R];

    }

}
