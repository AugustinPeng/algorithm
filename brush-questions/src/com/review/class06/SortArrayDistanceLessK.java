package com.review.class06;

import java.util.PriorityQueue;

/**
 * 已知一个几乎有序的数组。几乎有序是指，如果把数组排好顺序的话，每个元素移动的距离一定不超过k
 * k相对于数组长度来说是比较小的。请选择一个合适的排序策略，对这个数组进行排序。
 */
public class SortArrayDistanceLessK {

    public static void sortArrayDistanceLessK(int[] arr, int K){
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;
        for (; index < Math.min(arr.length, K); index++) {
            heap.add(arr[index]);
        }
        int i = 0;
        for (; index < arr.length; index++) {
            arr[i++] = heap.poll();
            heap.add(index);
        }
        while (!heap.isEmpty()){
            arr[i++] = heap.poll();
        }

    }
}
