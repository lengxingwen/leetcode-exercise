package com.algorithm;

/**
 * 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
 *
 * 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 *
 * 题目数据保证答案符合 32 位带符号整数范围。
 *
 * Created by leng on 2021/03/17.
 */
public class No115 {
    //动态规划 创建二维数组a[i][j] 代表s下标i到末尾的字符串的子序列中 t下标j到末尾的字符串 的出现次数；答案则为a[0][0]
    public int numDistinct(String s, String t) {
        int rows = s.length();
        int cols=t.length();
        if(rows<cols)return 0;
        int[][] a = new int[rows + 1][cols + 1];
        //边界条件 t的字串为空字符串
        for (int i = 0; i <=rows; i++) {
            a[i][cols]=1;
        }
        for (int i = rows-1; i >=0; i--) {
            char c = s.charAt(i);
            for (int j = cols-1; j >=0; j--) {
                char c1 = t.charAt(j);
                if(c==c1)
                    //如果两字符相同 则i的本次个数为i的上次循环中此次t子串的个数和上次t子串的个数之和
                a[i][j]=a[i+1][j+1]+a[i+1][j];
                //不相等，则s字串可去掉此字符结果相同
                else a[i][j]=a[i+1][j];
            }
        }
        return a[0][0];
    }
}
