package com.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * create by leng 31$ 22:02$
 **/
public class No90 {
    //迭代法实现子集枚举
    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int mask = 0; mask < (1 << n); ++mask) {   // 1<<n 表示总子集数 mask表示某一子集 0位代表不取，1位代表取
            t.clear();
            boolean flag = true;
            //遍历二进制表示子集的每一位
            for (int i = 0; i < n; ++i) {
                //如果i+1位为1 判断第i位未被取且i+1位对应的元素值等于i位对应的元素值 则此处不计入子集 进入下一位
                if ((mask & (1 << i)) != 0) {
                    if (i > 0 && (mask >> (i - 1) & 1) == 0 && nums[i] == nums[i - 1]) {
                        flag = false;
                        break;
                    }
                    t.add(nums[i]);
                }
            }
            if (flag) {
                ans.add(new ArrayList<Integer>(t));
            }
        }
        return ans;
    }
    //todo 递归
}
