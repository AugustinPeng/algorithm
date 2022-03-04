package com.brush.class01;

/**
 * 给定一个二维数组matrix，你可以从任何位置出发，走向上、下、左、右四个方向，返回能走出来的最长的递增链长度
 */
public class Solution5 {

    public static int maxLength1(int[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;
        int max = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int ans = process1(i, j, matrix);
                max = Math.max(max, ans);
            }
        }
        return max;
    }

    //暴力递归
    private static int process1(int curRow, int curCol, int[][] matrix) {
        if (curRow == matrix.length || curCol == matrix[0].length) {
            return 0;
        }
        int cur = matrix[curRow][curCol];
        int left = 0;
        int right = 0;
        int up = 0;
        int down = 0;
        if (curRow - 1 >= 0 && matrix[curRow - 1][curCol] > cur) {
            left = process1(curRow - 1, curCol, matrix);
        }
        if (curRow + 1 < matrix.length && matrix[curRow + 1][curCol] > cur) {
            right = process1(curRow + 1, curCol, matrix);
        }
        if (curCol - 1 >= 0 && matrix[curRow][curCol - 1] > cur) {
            up = process1(curRow, curCol - 1, matrix);
        }
        if (curCol + 1 < matrix[0].length && matrix[curRow][curCol + 1] > cur) {
            down = process1(curRow, curCol + 1, matrix);
        }
        return Math.max(Math.max(left, right), Math.max(up, down)) + 1;
    }

    public static int maxLength2(int[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;
        int max = 0;
        int[][] dp = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(max, process2(i, j, matrix, dp));
            }
        }
        return max;
    }

    //因为会多次到达同一位置，缓存dp记录当前位置开始的最长递增链
    private static int process2(int curRow, int curCol, int[][] matrix, int[][] dp) {
        if (curRow == matrix.length || curCol == matrix[0].length) {
            return 0;
        }
        if (dp[curRow][curCol] != 0) {
            return dp[curRow][curCol];
        }
        int cur = matrix[curRow][curCol];
        int left = 0;
        int right = 0;
        int up = 0;
        int down = 0;
        if (curRow - 1 >= 0 && matrix[curRow - 1][curCol] > cur) {
            left = process2(curRow - 1, curCol, matrix, dp);
        }
        if (curRow + 1 < matrix.length && matrix[curRow + 1][curCol] > cur) {
            right = process2(curRow + 1, curCol, matrix, dp);
        }
        if (curCol - 1 >= 0 && matrix[curRow][curCol - 1] > cur) {
            up = process2(curRow, curCol - 1, matrix, dp);
        }
        if (curCol + 1 < matrix[0].length && matrix[curRow][curCol + 1] > cur) {
            down = process2(curRow, curCol + 1, matrix, dp);
        }
        dp[curRow][curCol] = Math.max(Math.max(left, right), Math.max(up, down)) + 1;
        return dp[curRow][curCol];
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 4, 6, 5},
                {7, 8, 3, 2, 1},
                {1, 2, 3, 3, 2}
        };
        int i = maxLength1(matrix);
        System.out.println(i);
        int i1 = maxLength2(matrix);
        System.out.println(i1);
    }
}
