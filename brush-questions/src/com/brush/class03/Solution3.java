package com.brush.class03;

/**
 * 给定一个只有0和1组成的二维数组，返回边框全是1（内部无所谓）的最大正方形面积
 */
public class Solution3 {


    //
    public static int maxSquareArea(int[][] matrix){
        int M = matrix.length;
        if (M == 0){
            return 0;
        }
        int N = matrix[0].length;
        //每个点向右的最大连续为1的长度
        int[][] right = new int[M][N];
        //每个点向下的最大连续为1的长度
        int[][] down = new int[M][N];
        createRightAndDown(matrix, right, down);
        for (int border = Math.min(M, N); border > 0; border--) {
            if (hasAffirmed(matrix, right, down, border)){
                return border * border;
            }
        }
        return 0;
    }

    private static boolean hasAffirmed(int[][] matrix, int[][] right, int[][] down, int border) {
        int M = matrix.length;
        int N = matrix[0].length;
        for (int i = 0; i <= M - border; i++) {
            for (int j = 0; j <= N - border; j++) {
                if (right[i][j] >= border && down[i][j] >= border && right[i + border -1][j] >= border && down[i][j + border -1] >= border){
                    return true;
                }
            }
        }
        return false;
    }

    private static void createRightAndDown(int[][] matrix, int[][] right, int[][] down) {
        int M = matrix.length;
        int N = matrix[0].length;
        for (int i = 0; i < M; i++) {
            right[i][N -1] = matrix[i][N -1] == 0 ? 0 : 1;
        }
        for (int i = N - 2; i >= 0; i--) {
            for (int j = 0; j < M; j++) {
                right[j][i] = matrix[j][i] == 0 ? 0 : right[j][i + 1] + 1;
            }
        }
        for (int i = 0; i < N; i++) {
            down[M -1][i] = matrix[M -1][i] == 0 ? 0 : 1;
        }
        for (int i = M - 2; i >= 0 ; i--) {
            for (int j = 0; j < N; j++) {
                down[i][j] = matrix[i][j] == 0 ? 0 : down[i+ 1][j] + 1;
            }
        }
    }

    public static void main(String[] args) {
        //321   313
        //101   202
        //321   111
        int[][] matrix = {
                {1,1,0,1}
//                {1, 1, 1},
//                {1, 0, 1},
//                {1, 1, 1},
        };
        int i = maxSquareArea(matrix);
        System.out.println(i);
    }
}
