package com.review.class03;

/**
 *  双链表实现栈和队列
 */
public class DoubleEndsQueueToStackAndQueue {

    static class Node<T> {
        T value;
        Node<T> next;
        Node<T> pre;
        public Node(T data){
            value = data;
        }
    }

    static class DoubleEndsQueue<T> {
        public Node<T> head;
        public Node<T> tail;

        public void addFromHead(T value){
            Node<T> node = new Node<T>(value);
            if (head == null){
                head = node;
                tail = node;
            }else {
                node.next = head;
                head.pre = node;
                head = node;
            }
        }

        public void addFromTail(T value){
            Node<T> node = new Node<T>(value);
            if (tail == null){
                head = node;
                tail = node;
            }else {
                tail.next = node;
                node.pre = tail;
                tail = node;
            }
        }

        public T popFromHead(){
            if (head == null){
                return null;
            }
            Node<T> res = head;
            if (head == tail){
                head = null;
                tail = null;
                return res.value;
            }
            head = head.next;
            res.next = null;
            head.pre = null;
            return res.value;
        }

        public T popFromTail(){
            if (head == null){
                return null;
            }
            Node<T> res = tail;
            if (head == tail){
                head = null;
                tail = null;
            }else {
                tail = tail.pre;
                res.pre = null;
                tail.next = null;
            }
            return res.value;
        }

        public boolean isEmpty(){
            return head == null;
        }
    }

    static class MyStack<T> {
        DoubleEndsQueue<T> stack;
        public MyStack(){
            stack = new DoubleEndsQueue<T>();
        }
        public void push(T value){
            stack.addFromHead(value);
        }
        public T pop(){
            return stack.popFromHead();
        }
        public boolean isEmpty(){
            return stack.isEmpty();
        }
    }

    static class MyQueue<T> {
        DoubleEndsQueue<T> queue;
        public MyQueue(){
            queue = new DoubleEndsQueue<>();
        }
        public void push(T value) {
            queue.addFromHead(value);
        }

        public T poll() {
            return queue.popFromTail();
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }
}
