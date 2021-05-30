package com.algorithm;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * create by leng 06$ 22:23$
 **/
public class No80 {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int slow = 2, fast = 2;
        while (fast < n) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }
    public int removeDuplicates1(int[] nums){
        int length=nums.length;
        if(length<=2)return length;
        int slow=2;
        for (int fast=2;fast<length;fast++){
            if(nums[slow-2]!=nums[fast]){
                nums[slow]=nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
