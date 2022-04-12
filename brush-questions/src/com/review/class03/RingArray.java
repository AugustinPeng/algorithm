package com.review.class03;

/**
 *  环形数组实现栈和队列
 */
public class RingArray {

    static class MyQueue {
        int[] arr;
        int size;
        final int limit;
        int pushi = 0;
        int polli = 0;

        public MyQueue(int limit) {
            this.limit = limit;
        }

        public void push(int value){
            if (size == limit){
                throw new RuntimeException("队列已满");
            }
            size++;
            arr[pushi] = value;
            pushi = nextIndex(pushi);
        }

        public int pop(){
            if (size == 0){
                throw new RuntimeException("队列已空");
            }
            size--;
            int ans = arr[polli];
            polli = nextIndex(polli);
            return ans;
        }

        public boolean isEmpty(){
            return size == 0;
        }

        //index到头了重新从0开始模拟成环
        public int nextIndex(int index){
            return index < limit -1 ? index +1 : 0;
        }
    }
}
