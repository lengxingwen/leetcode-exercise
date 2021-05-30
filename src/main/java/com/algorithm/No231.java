package com.algorithm;

/**
 * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * 如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。
 *
 * @author leng
 * @date 2021/5/30 9:02
 */

public class No231 {
    static final int BIG = 1 << 30;

    //取巧方法 判断n是不是最大2的幂次方int的因数
    public boolean isPowerOfTwo0(int n) {
        return n > 0 && BIG % n == 0;
    }

    //二进制表示 一个整数是2的幂次方 当且仅当n>0,二进制的值只有一个1
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
    //二进制表示  n & (-n)表示n的最低位的1
    public boolean isPowerOfTwo1(int n) {
        return n > 0 && (n & -n) == n;
    }
}
