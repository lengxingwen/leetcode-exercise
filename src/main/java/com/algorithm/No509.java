package com.algorithm;

/**
 * * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 *  * F(0) = 0，F(1) = 1
 *  * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 *  * 给你 n ，请计算 F(n) 。
 * Created by leng on 2021/01/04.
 */
public class No509 {
    //矩阵
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = pow(q, n - 1);
        return res[0][0];
    }

    public int[][] pow(int[][] a, int n) {
        int[][] ret = {{1, 0}, {0, 1}};
        while (n > 0) {
            if ((n & 1) == 1) {
                ret = multiply(ret, a);
            }
            n >>= 1;
            a = multiply(a, a);
        }
        return ret;
    }

    public int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
            }
        }
        return c;
    }

    //通项公式
    public int fib1(int n) {
        double sqrt5 = Math.sqrt(5);
        double fibN = Math.pow((1 + sqrt5) / 2, n) - Math.pow((1 - sqrt5) / 2, n);
        return (int) Math.round(fibN / sqrt5);
    }

    //动态规划
    public int fib2(int n){
        if(n<2){
            return n;
        }
        int a=0,b=0,c=1;
        for (int i = 2; i <= n; i++) {
            a=b;
            b=c;
            c=a+b;
        }
        return c;
    }
}
