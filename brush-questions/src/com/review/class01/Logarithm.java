package com.review.class01;

import java.util.Arrays;

/**
 * 生成随机数组
 */
public class Logarithm {

    //生成0-100 随机0-20长度数组
    public static int[] generateArr(){
        int N = (int) (Math.random() * 100) / 5;
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        return arr;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int[] arr = generateArr();
            System.out.println(Arrays.toString(arr));
        }


    }
}
