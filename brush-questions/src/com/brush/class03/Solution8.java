package com.brush.class03;

import java.util.*;

/**
 *  给定三个参数，二叉树的头节点head，树上某个节点target，正数K。从target开始，可以向上走或者向下走，返回与target的距离是K的所有节点
 */
public class Solution8 {

    static class Node {
        Node left;
        Node right;
        int value;
        public Node(int data){
            value = data;
        }
    }

    public static List<Node> distanceK(Node root, Node target, int k){
        //存放节点向上的关系
        Map<Node, Node> map = new HashMap<>();
        map.put(root, null);
        createParent(map, root);
        List<Node> ans = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        queue.offer(target);
        visited.add(target);
        int curLevel = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            //size 每层刚好有size个
            while (size-- > 0){
                Node poll = queue.poll();
                if (curLevel == k){
                    ans.add(poll);
                }
                if (poll.left != null && !visited.contains(poll.left)){
                    queue.offer(poll.left);
                    visited.add(poll.left);
                }
                if (poll.right != null && !visited.contains(poll.right)){
                    queue.offer(poll.right);
                    visited.add(poll.right);
                }
                if (map.get(poll) != null && !visited.contains(map.get(poll))){
                    queue.offer(map.get(poll));
                    visited.add(map.get(poll));
                }
            }
            curLevel++;
            if (curLevel > k){
                break;
            }
        }
        return ans;
    }

    public static void createParent(Map<Node, Node> map, Node node){
        if (node == null){
            return;
        }
        if (node.left != null){
            map.put(node.left, node);
            createParent(map, node.left);
        }
        if (node.right != null){
            map.put(node.right, node);
            createParent(map, node.right);
        }
    }

    public static void main(String[] args) {
        Node n0 = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);

        n3.left = n5;
        n3.right = n1;
        n5.left = n6;
        n5.right = n2;
        n1.left = n0;
        n1.right = n8;
        n2.left = n7;
        n2.right = n4;

        Node root = n3;
        Node target = n5;
        int K = 2;

        List<Node> ans = distanceK(root, target, K);
        for (Node o1 : ans) {
            System.out.println(o1.value);
        }

    }

}
