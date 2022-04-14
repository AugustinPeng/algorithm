package com.brush.class03;

import java.util.HashSet;
import java.util.Set;

/**
 * 求一个字符串中，最长无重复字符子串长度
 *
 * 以i为结尾考虑 动态规划
 *
 * 双指针
 */
public class Solution1 {

    public static int longestNoRepetitionString1(String s){
        char[] str = s.toCharArray();
        int N = str.length;
        //以 i 结尾的最长子串 依赖 (i-1)位置的最长字串长度 和 str[i] 上一次出现的位置x
        // p1 (i-1) - (以i-1结尾的最长字串长度) > (str[i] 上一次出现的位置x)  = (i-1)结尾最长长度 + 1
        // p2 (i-1) - (以i-1结尾的最长字串长度) < (str[i] 上一次出现的位置x)  = i - x
        // ans = Math.min(p1,p2)
        // location 记录每个字符最新出现的位置 0-N
        int[] location = new int[256];
        for (int i = 0; i < 256; i++) {
            location[i] = -1;
        }
        location[str[0]] = 0;
        //(i-1)位置的最长长度
        int pre = 1;
        int max = 1;
        for (int i = 1; i < N; i++) {
            //如果location[str[i]] == -1  因为 pre + 1 <= i 所以 i - (-1) 肯定>pre + 1
            //不会影响最小值选择
            pre = Math.min(pre + 1, i - location[str[i]]);
            location[str[i]] = i;
            max = Math.max(pre, max);
        }
        return max;
    }

    public static int longestNoRepetitionString2(String s){
        char[] str = s.toCharArray();
        int N = str.length;
        int p1 = 0;
        int p2 = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();
        while (p1 < N && p2 < N){
            if (set.contains(str[p2])){
                set.remove(str[p1++]);
            }else {
                set.add(str[p2++]);
                max = Math.max(max, set.size());
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "jasjkdbnjfbasf";
        int ans1 = longestNoRepetitionString1(s);
        int ans2 = longestNoRepetitionString2(s);
        System.out.println(ans1);
        System.out.println(ans2);
    }
}
