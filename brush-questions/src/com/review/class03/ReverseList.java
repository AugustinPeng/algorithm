package com.review.class03;

public class ReverseList {

    public static Node reverseNode(Node head){
        Node pre = null;
        while (head != null){
            Node cur = head.next;
            head.next = pre;
            pre = head;
            head = cur;
        }
        return pre;
    }

    public static DoubleNode reverseDoubleNode(DoubleNode head){
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            head.pre = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        Node ans = reverseNode(head);
        while (ans != null){
            System.out.print(ans.value + " ");
            ans = ans.next;
        }
    }
}
