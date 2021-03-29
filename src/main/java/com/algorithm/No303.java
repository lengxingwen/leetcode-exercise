package com.algorithm;

/**
 * 给定一个整数数组  nums，求出数组从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点。
 *
 * 实现 NumArray 类：
 *
 * NumArray(int[] nums) 使用数组 nums 初始化对象
 * int sumRange(int i, int j) 返回数组 nums 从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点（也就是 sum(nums[i], nums[i + 1], ... , nums[j])）
 * Created by leng on 2021/03/01.
 */
public class No303 {
}

class NumArray {
    //前缀和数组
    int[] sums;
    public NumArray(int[] nums) {
        int length = nums.length;
        sums=new int[length+1];
        for (int i = 0; i <length ; i++) {
            sums[i+1]=sums[i]+nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sums[j+1]-sums[i];
    }
}