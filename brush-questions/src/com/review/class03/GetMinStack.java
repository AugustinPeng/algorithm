package com.review.class03;

import java.util.Stack;

/**
 *  可以获取min的栈
 *
 */
public class GetMinStack {

    static class MyStack {
        Stack<Integer> stackData;
        Stack<Integer> stackMin;

        public MyStack(){
            stackData = new Stack<>();
            stackMin = new Stack<>();
        }

        public void push(int value){
            if (stackMin.isEmpty()){
                stackData.push(value);
                stackMin.push(value);
            }else {
                if (stackMin.peek() > value){
                    stackMin.push(value);
                }else {
                    stackMin.push(stackMin.peek());
                }
                stackData.push(value);
            }
        }

        public int pop(){
            if (stackData.isEmpty()){
                throw new RuntimeException("栈已空");
            }
            int ans = stackData.pop();
            stackMin.pop();
            return ans;
        }

        public int getMin(){
            if (stackMin.isEmpty()){
                throw new RuntimeException("栈已空");
            }
            return stackMin.peek();
        }
    }
}
