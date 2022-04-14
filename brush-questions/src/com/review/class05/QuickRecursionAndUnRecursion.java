package com.review.class05;

import com.review.class01.Logarithm;

import java.util.*;

/**
 *  快排的非递归实现
 */
public class QuickRecursionAndUnRecursion {

    static class OP {
        int L;
        int R;
        public OP(int l,int r){
            L = l;
            R = r;
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //栈实现
    public static void quickSortUnRecursion1(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        int[] p = partition(arr, 0, arr.length - 1);
        Stack<OP> stack = new Stack<>();
        stack.push(new OP(0, p[0]));
        stack.push(new OP(p[1], arr.length -1));
        while (!stack.isEmpty()){
            OP pop = stack.pop();
            if (pop.L < pop.R){
                p = partition(arr, pop.L, pop.R);
                stack.push(new OP(pop.L, p[0]));
                stack.push(new OP(p[1], pop.R));
            }
        }
    }

    //队列实现
    public static void quickSortUnRecursion2(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        int[] p = partition(arr, 0, arr.length - 1);
        Queue<OP> queue = new LinkedList<>();
        queue.offer(new OP(0, p[0]));
        queue.offer(new OP(p[1], arr.length -1));
        while (!queue.isEmpty()){
            OP poll = queue.poll();
            if (poll.L < poll.R){
                p = partition(arr, poll.L, poll.R);
                queue.offer(new OP(poll.L, p[0]));
                queue.offer(new OP(p[1], poll.R));
            }
        }
    }

    public static int[] partition(int[] arr, int L, int R){
        if (L > R){
            return new int[]{-1, -1};
        }
        if (L == R){
            return new int[]{L, R};
        }
        int less = L -1;
        int more = R + 1;
        int index = L;
        int target = arr[L + (int) (Math.random() * (R - L + 1))];
        while (index < more){
            if (arr[index] < target){
                swap(arr, index++, ++less);
            }else if (arr[index] > target){
                swap(arr, index, --more);
            }else {
                index++;
            }
        }
        return new int[]{less, more};
    }

    public static void main(String[] args) {
        int[] arr = Logarithm.generateArr();
        System.out.println(Arrays.toString(arr));
//        quickSortUnRecursion1(arr);
        quickSortUnRecursion2(arr);
        System.out.println(Arrays.toString(arr));
    }
}
