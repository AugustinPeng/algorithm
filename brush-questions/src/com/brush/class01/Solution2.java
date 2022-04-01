package com.brush.class01;

import java.io.File;
import java.util.Stack;

/**
 * 给定一个文件目录的路径，写一个函数统计这个目录下所有的文件数量并返回，隐藏文件也算，但是文件夹不算
 *
 * 广度优先
 *      队列
 * 深度优先
 *      栈
 */
public class Solution2 {

    public static int getFileNum(String path) {
        File file = new File(path);
        if (!file.isDirectory() && !file.isFile()) {
            return 0;
        }
        if (file.isFile()) {
            return 1;
        }
        int res = 0;
        Stack<File> stack = new Stack<>();
        stack.push(file);
        while (!stack.isEmpty()) {
            File pop = stack.pop();
            File[] files = pop.listFiles();
            for (File f : files) {
                if (f.isFile()){
                    res++;
                }
                if (f.isDirectory()){
                    stack.push(f);
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {

    }
}
