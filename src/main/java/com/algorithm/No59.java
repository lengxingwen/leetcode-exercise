package com.algorithm;

/**
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * Created by leng on 2021/03/16.
 */
public class No59 {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int top=0,bottom=n-1,left=0,right=n-1;
        int i;
        int a=1;
        while(top<=bottom&&left<=right){
            for (i=left;i<=right;i++){
                ans[top][i]=a;
                a++;
            }
            for(i=top+1;i<=bottom;i++){
                ans[i][right]=a;
                a++;
            }
            if(top<bottom&&left<right){
                for(i=right-1;i>left;i--){
                    ans[bottom][i]=a;
                    a++;
                }
                for(i=bottom;i>top;i--){
                    ans[i][left]=a;
                    a++;
                }
            }
            top++;
            bottom--;
            left++;
            right--;
        }
        return ans;
    }

    public static void main(String[] args) {
        new No59().generateMatrix(2);
    }
}
