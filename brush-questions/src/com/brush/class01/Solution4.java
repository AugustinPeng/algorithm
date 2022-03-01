package com.brush.class01;


/**
 * 一个数组中只有两种字符'G'和'B'，可以让所有的G都放在左侧，所有的B都放在右侧
 * 或者可以让所有的G都放在右侧，所有的B都放在左侧，但是只能在相邻字符之间进行交换操作，返回至少需要交换几次
 */
public class Solution4 {

    public static int minSteps1(char[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int step1 = 0;
        int gIndex = 0;
        //遍历数组 依次将G移动到从0开始下标记录次数
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'G') {
                step1 += i - (gIndex++);
            }
        }
        int step2 = 0;
        int bIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'B') {
                step2 += i - (bIndex++);
            }
        }
        return Math.min(step1, step2);
    }


    public static void main(String[] args) {
        int step1 = minSteps1("BGGBGBGBGBGGGG".toCharArray());
        System.out.println(step1);
    }
}
