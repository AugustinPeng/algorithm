package com.review.class06;


/**
 *  实现堆结构
 *  heapInsert
 *  heapify
 */
public class MyHeap {

    int[] heap;
    int limit;
    int heapSize = 0;

    private void swap(int i, int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public MyHeap(int len){
        heap = new int[len];
        limit = len;
    }

    public boolean isEmpty(){
        return heapSize == 0;
    }

    public int pop(){
        if (heapSize == 0){
            throw new RuntimeException("堆已经空了");
        }
        int ans = heap[0];
        swap(0, --heapSize);
        heapify();
        return ans;
    }

    private void heapify() {
        int curIndex = 0;
        int leftIndex = curIndex * 2 + 1;
        int rightIndex = curIndex * 2 + 2;
        while (leftIndex < heapSize){
            int biggerIndex = rightIndex < heapSize && heap[rightIndex] > heap[leftIndex] ? rightIndex : leftIndex;
            if (heap[curIndex] < heap[biggerIndex]){
                swap(biggerIndex, curIndex);
                curIndex = biggerIndex;
                leftIndex = curIndex * 2 + 1;
                rightIndex = curIndex * 2 + 2;
            }else {
                break;
            }
        }
    }

    public void push(int value){
        if (limit == heapSize){
            throw new RuntimeException("堆已满");
        }
        heap[heapSize++] = value;
        heapInsert();
    }

    private void heapInsert() {
        int curIndex = heapSize -1;
        while (heap[curIndex] > heap[(curIndex -1) / 2]){
            swap(curIndex, (curIndex -1) / 2);
            curIndex = (curIndex -1) / 2;
        }
    }

    public static void main(String[] args) {
        MyHeap myHeap = new MyHeap(5);
        myHeap.push(41);
        myHeap.push(53);
        myHeap.push(33);
        myHeap.push(33);
        myHeap.push(66);
        while (!myHeap.isEmpty()){
            System.out.println(myHeap.pop());
        }
    }
}
