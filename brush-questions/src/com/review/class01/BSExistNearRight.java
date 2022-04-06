package com.review.class01;

import java.util.Arrays;

/**
 *  有序数组中找到<=target的最右位置
 */
public class BSExistNearRight {

    public static int existNearRight(int[] arr, int target){
        int L = 0;
        int R = arr.length -1;
        int index = -1;
        while (L <= R){
            int mid = L + (R - L) / 2;
            if (arr[mid] <= target){
                index = mid;
                L = mid + 1;
            }else {
                R = mid - 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = Logarithm.generateArr();
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(existNearRight(arr, 15));
    }
}
