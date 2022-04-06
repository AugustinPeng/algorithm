package com.brush.class01;

import java.util.HashMap;

/**
 * 给定一个数组arr，你可以在每个数字之前决定+或者-但是必须所有数字都参与，再给定一个数target
 * 请问最后算出target的方法数
 *
 * 动态规划
 *
 * 空间压缩
 */
public class Solution7 {


    //暴力递归
    public static int sameSumMaxNum1(int[] arr, int target){
        return process1(arr, 0, target);
    }

    public static int process1(int[] arr, int curIndex, int rest){
        if (curIndex == arr.length){
            return rest == 0 ? 1 : 0;
        }
        int p1 = process1(arr, curIndex +1, rest + arr[curIndex]);
        int p2 = process1(arr, curIndex +1, rest - arr[curIndex]);
        return p1 + p2;
    }

    //动态规划
    public static int sameSumMaxNum2(int[] arr, int target){
        int N = arr.length;
        int[][] dp = new int[N + 1][target + 1];

        // dp[i][j] : nums前缀长度为i的所有子集，有多少累加和是j？
        // nums前缀长度为0的所有子集，有多少累加和是0？一个：空集
        dp[0][0] = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - arr[i - 1] >= 0){
                    dp[i][j] += dp[i -1][j - arr[i - 1]];
                }
                if (j + arr[i - 1] <= target){
                    dp[i][j] += dp[i - 1][j + arr[i - 1]];
                }
            }
        }

        return dp[N][target];
    }

 

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int i = sameSumMaxNum1(arr, 3);
        int j = sameSumMaxNum2(arr, 3);
        System.out.println(i);
        System.out.println(j);
    }
}
