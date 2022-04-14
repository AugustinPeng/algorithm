package com.brush.class03;

import java.util.Arrays;

/**
 * 给定一个数组arr，代表每个人的能力值。再给定一个非负数k，如果两个人能力差值正好为k，那么可以凑在一起比赛
 * 一局比赛只有两个人，返回最多可以同时有多少场比赛
 *
 * 贪心思想
 */
public class Solution4 {

    public static int mostMatches(int[] arr, int k){
        int N = arr.length;
        Arrays.sort(arr);
        int p1 = 0;
        int p2 = 0;
        int ans = 0;
        boolean[] used = new boolean[N];
        while (p2 < N){
            if (used[p1]){
                p1++;
            }else if(p1 >= p2){
                p2++;
            }else {
                int distance = arr[p2] - arr[p1];
                if (distance == k){
                    ans++;
                    used[p2++] = true;
                    p1++;
                }else if (distance < k){
                    p2++;
                }else {
                    p1++;
                }
            }
        }
        return ans;
    }
}
