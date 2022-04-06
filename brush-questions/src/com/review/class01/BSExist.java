package com.review.class01;

import java.util.Arrays;

/**
 * 有序数组找到target
 */
public class BSExist {

    public static boolean exist(int[] arr, int target){
        int L = 0;
        int R = arr.length -1;
        while (L <= R){
            int mid = L + (R - L) / 2;
            if (arr[mid] == target){
                return true;
            }else if(arr[mid] > target){
                R = mid -1;
            }else {
                L = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            int[] arr = Logarithm.generateArr();
            Arrays.sort(arr);
            System.out.println(Arrays.toString(arr));
            System.out.println(exist(arr, 17));
        }

    }
}
