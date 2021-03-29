package com.algorithm;

/**
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
 * Created by leng on 2021/03/22.
 */
public class No191 {
    public int hammingWeight(int n) {
        int m;
        int ans;
        if(n>=0){
             m=n>>1;
             ans=n%2;
            while (m!=0){
                ans+=m%2;
                m=m>>1;
            }
            return ans;
        }else {
            n=n-Integer.MIN_VALUE;
            m=n>>1;
            ans=n%2;
            while (m!=0){
                ans+=m%2;
                m=m>>1;
            }
            return ans+1;
        }
    }

    public int hammingWeight1(int n){
        int ans=0;
        for (int i = 0; i < 32; i++) {
            if((n&(1<<i))!=0){
                ans++;
            }
        }
        return ans;
    }

    public int hammingWeight2(int n){
        int ans=0;
        while(n!=0){
            ans++;
            n&=(n-1);
        }
        return ans;
    }
}
