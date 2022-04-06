package com.review.class01;

/**
 *  局部最小值
 */
public class BSAwesome {

    public static int awesome(int[] arr){
        int L = 0;
        int R = arr.length -1;
        if (arr[L] < arr[L + 1]){
            return L;
        }
        if (arr[R] < arr[R - 1]){
            return R;
        }
        while (L <= R){
            int mid = (L + R) / 2;
            if (arr[mid] > arr[mid - 1]) {
                L = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {
                R = mid + 1;
            } else {
                return mid;
            }
        }
        return L;
    }

    public static void main(String[] args) {

    }
}
