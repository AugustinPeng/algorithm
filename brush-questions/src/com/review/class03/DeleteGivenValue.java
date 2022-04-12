package com.review.class03;

/**
 *  链表中删除指定值的所有节点
 */
public class DeleteGivenValue {


    public static Node deleteAllValue(Node head, int value){
        while (head != null && head.value == value){
            head = head.next;
        }
        Node next = head;
        while (next.next != null){
            if (next.next.value == value){
                next.next = next.next.next;
            }else {
                next = next.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(3);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(3);
        Node ans = deleteAllValue(head, 3);
        while (ans != null){
            System.out.print(ans.value + " ");
            ans = ans.next;
        }
    }
}
