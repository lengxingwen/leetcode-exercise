package com.algorithm;

/**
 * 给你两个整数，n 和 start 。
 *
 * 数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。
 *
 * 请返回 nums 中所有元素按位异或（XOR）后得到的结果。
 * create by leng 07$ 22:31$
 **/
public class No1486 {
    public int xorOperation(int n, int start) {
        int result=start;
        if(n==1){
            return result;
        }
        for (int i = 1; i < n; i++) {
            result^=(start+2*i);
        }
        return result;
    }
    public int xorOperation1(int n, int start) {
        int s = start >> 1, e = n & start & 1;
        int ret = sumXor(s - 1) ^ sumXor(s + n - 1);
        return ret << 1 | e;
    }

    public int sumXor(int x) {
        if (x % 4 == 0) {
            return x;
        }
        if (x % 4 == 1) {
            return 1;
        }
        if (x % 4 == 2) {
            return x + 1;
        }
        return 0;
    }
}
