package com.brush.class02;

/**
 *  现有司机N*2人，调度中心会将所有司机平分给A、B两区域，i号司机去A可得收入为income[i][0]，去B可得收入为income[i][1]
 *  返回能使所有司机总收入最高的方案是多少钱?
 */
public class Solution4 {


    public static int maxMoney1(int[][] income){
        int N = income.length >> 1;
        return process1(income, 0, N);
    }

    // A 区还剩rest个位子可选
    public static int process1(int[][] income, int index, int rest){
        if (index == income.length){
            return 0;
        }
        if (rest == 0){
            //只能选B区
            return process1(income, index +1, rest) + income[index][1];
        }
        if (income.length - index == rest){
            //只能选A区
            return process1(income, index +1, rest -1) + income[index][0];
        }
        //选B区
        int p1 = process1(income, index +1, rest) + income[index][1];
        //选A区
        int p2 = process1(income, index +1, rest -1) + income[index][0];
        return Math.max(p1, p2);
    }

    //动态规划
    public static int maxMoney2(int[][] income){
        int N = income.length;
        int rest = N >> 1;
        int[][] dp = new int[N + 1][rest + 1];
        for (int i = N -1; i >= 0; i--) {
            dp[i][0] = dp[i + 1][0] + income[i][1];
        }
        for (int i = N -1; i >= 0 ; i--) {
            for (int j = 1; j <= rest; j++) {
                if (income.length - i == j){
                    dp[i][j] = dp[i + 1][j -1] + income[i][0];
                }else {
                    dp[i][j] = Math.max((dp[i + 1][j] + income[i][1]),(dp[i + 1][j -1]) + income[i][0]);
                }

            }
        }
        return dp[0][rest];
    }

    public static void main(String[] args) {
        int[][] income = {
                {25,5},
                {5,7},
                {7,85},
                {2,4},
                {5,6},
                {2,9},
        };
        System.out.println(maxMoney1(income));
        System.out.println(maxMoney2(income));
    }
}
