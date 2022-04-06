package com.review.class01;

import java.util.Arrays;

/**
 * 有序数组找到>=target的最左位置
 */
public class BSExistNearLeft {


    public static int existNearLeft(int[] arr, int target){
        int L = 0;
        int R = arr.length -1;
        //可能不存在
        int index = -1;
        while (L <= R){
            int mid = L + (R - L)/ 2;
            if (arr[mid] >= target){
                index = mid;
                R = mid - 1;
            }else {
                L = mid + 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            int[] arr = Logarithm.generateArr();
            Arrays.sort(arr);
            System.out.println(Arrays.toString(arr));
            int ans = existNearLeft(arr, 15);
            System.out.println(ans);
        }

    }
}
