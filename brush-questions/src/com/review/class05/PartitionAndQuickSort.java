package com.review.class05;

import com.review.class01.Logarithm;

import java.util.Arrays;

/**
 *  快排演变
 */
public class PartitionAndQuickSort {

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //荷兰国旗问题
    //小于target放左边等于target放中间大于target放右边
    public static void DutchFlag(int[] arr, int target){

    }

    //partition过程
    // 小于x排左边 大于x排右边 返回 排序后最后一个大于等于x的位置
    public static int partition(int[] arr, int L, int R){
        if (L > R){
            return -1;
        }
        if (L == R){
            return L;
        }
        int lessEqual = L - 1;
        int index = L;
        while (index < R){
            if (arr[index] <= arr[R]){
                swap(arr, index, ++lessEqual);
            }
            index++;
        }
        swap(arr,++lessEqual,R);
        return lessEqual;
    }

    //第一个小于x 和第一个大于x
    public static int[] netherlandsFlag(int[] arr, int L, int R){
        if (L > R){
            return new int[]{-1,-1};
        }
        if (L == R){
            return new int[]{L,R};
        }
        int less = L -1;
        int more = R + 1;
        int index = L;
//        int target = arr[R];
        //随机快排
        int target = arr[(int) (Math.random() * (R - L + 1)) + L];
        while (index < more){
            if (arr[index] < target){
                swap(arr, ++less,index++);
            }else if (arr[index] > target){
                swap(arr, --more,index);
            }else {
                index++;
            }
        }
        return new int[]{less, more};
    }

    public static void quickSort1(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        process1(arr, 0, arr.length -1);
    }

    public static void process1(int[] arr, int L, int R){
        if (L >= R){
            return;
        }
        int[] partition = netherlandsFlag(arr, L, R);
        process1(arr,L , partition[0]);
        process1(arr, partition[1], R);
    }


    public static void main(String[] args) {
        int[] arr = Logarithm.generateArr();
        System.out.println(Arrays.toString(arr));
        quickSort1(arr);
        System.out.println(Arrays.toString(arr));
    }
}
