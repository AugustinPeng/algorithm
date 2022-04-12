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
            //只能选A区
            return process1(income, index +1, rest) + income[index][1];
        }
        //选B区
        int p1 = process1(income, index +1, rest) + income[index][1];
        //选A区
        int p2 = process1(income, index +1, rest -1) + income[index][0];
        return Math.max(p1, p2);
    }

    public static void main(String[] args) {
        int[][] income = {
                {},
                {},
                {},
                {},
                {},
                {},
        };
        maxMoney1()
    }
}
