package com.brush.class01;

import java.util.Arrays;

/**
 * 给定一个有序数组arr，代表坐落在X轴上的点，给定一个正数K，代表绳子的长度，返回绳子最多压中几个点？
 * 即使绳子边缘处盖住点也算盖住
 *
 *
 * 贪心 以每个点为结尾最多向前覆盖多少点，
 */
public class Solution1 {

    //暴力解 时间复杂度O(N^2)
    public static int maxPoint1(int[] arr, int K) {
        int N = arr.length;
        int ans = 0;
        for (int i = 0; i < N; i++) {
            int start = arr[i];
            int j = i + 1;
            while (j < N && arr[j] <= start + K) {
                j++;
            }
            ans = Math.max(ans, j - i);
        }
        return ans;
    }

    //二分法优化 时间复杂度O(N*logN)
    public static int maxPoint2(int[] arr, int K) {
        int N = arr.length;
        int ans = 1;
        for (int i = 0; i < N; i++) {
            int index = getNearestIndex(arr, i, K);
            ans = Math.max(ans, index - i);
        }
        return ans;
    }

    //把找到最接近index的过程优化
    //获取以i开始刚好超出绳长范围的下标
    private static int getNearestIndex(int[] arr, int i, int K) {
        int L = i;
        int R = arr.length - 1;
        int target = arr[i] + K;
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            //如果刚好命中也取下一个index值
            if (arr[mid] <= target) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return L;
    }

    // for test
    public static int[] generateArray(int len, int max) {
        int[] ans = new int[(int) (Math.random() * len) + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = (int) (Math.random() * max);
        }
        Arrays.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        int len = 100;
        int max = 1000;
        int testTime = 100000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int K = (int) (Math.random() * max);
            int[] arr = generateArray(len, max);
            int ans1 = maxPoint1(arr, K);
            int ans2 = maxPoint2(arr, K);
            if (ans1 != ans2) {
                System.out.println("oops!");
                break;
            }
        }

    }
}
