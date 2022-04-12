package com.brush.class02;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

/**
 *  给定数组hard和money，长度都为N，hard[i]表示i号工作的难度， money[i]表示i号工作的收入
 * 给定数组ability，长度都为M，ability[j]表示j号人的能力，每一号工作，都可以提供无数的岗位，难度和收入都一样
 * 但是人的能力必须>=这份工作的难度，才能上班。返回一个长度为M的数组ans，ans[j]表示j号人能获得的最好收入
 *
 *
 * 有序表treemap 查询时间复杂度logN   也可以自己写二分
 * 边界条件判断
 */
public class Solution1 {

    static class Job {
        int hard;
        int money;
        public Job(int h, int m) {
            hard = h;
            money = m;
        }
    }

    static class JobComparator implements Comparator<Job> {
        @Override
        public int compare(Job o1, Job o2) {
            return o1.hard == o2.hard ? o2.money - o1.money : o1.hard - o2.hard;
        }
    }

    public static int[] maxIncome(int[] hard, int[] money, int[] ability){
        int N = hard.length;
        Job[] jobs = new Job[N];
        for (int i = 0; i < N; i++) {
            jobs[i] = new Job(hard[i], money[i]);
        }
        Arrays.sort(jobs, new JobComparator());
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(jobs[0].hard, jobs[0].money);
        Job pre = jobs[0];
        for (int i = 1; i < N; i++) {
            if (jobs[i].hard > pre.hard && jobs[i].money > pre.money){
                map.put(jobs[i].hard, jobs[i].money);
                pre = jobs[i];
            }
        }
        int[] res = new int[ability.length];
        for (int i = 0; i < ability.length; i++) {
            Integer key = map.floorKey(ability[i]);
            res[i] = key == null ? 0 : map.get(key);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] hard = { 3,4,64,3,5,6};
        int[] money = {24,6,3,45,8,75};
        int[] ability = {2,3,5,6,3,5,6,7};
        int[] ints = maxIncome(hard, money, ability);
        System.out.println(Arrays.toString(ints));
    }
}
