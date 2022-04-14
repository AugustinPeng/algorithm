package com.brush.class03;

import java.util.HashSet;
import java.util.Set;

/**
 * 只由小写字母（a~z）组成的一批字符串，都放在字符类型的数组String[] arr中，如果其中某两个字符串所含有的字符种类完全一样
 * 就将两个字符串算作一类，比如baacbba和bac就算作一类，返回arr中有多少类
 */
public class Solution2 {

    public static int maxKinds(String[] arr){
        Set<Integer> set = new HashSet<>();
        for (String s : arr) {
            char[] str = s.toCharArray();
            //a-z - 'a' =  0-25
            int types = str[0] - 'a';
            for (int i = 1; i < str.length; i++) {
                //types |= 1 << (str[i] - 'a');
                types |= (str[i] - 'a');
            }
            set.add(types);
        }
        return set.size();
    }

    public static void main(String[] args) {
        String[] arr = {
                "acbabcb",
                "acbbacb",
                "acbbbbbbbbb",
                "aec",
        };
        System.out.println(maxKinds(arr));
    }
}
