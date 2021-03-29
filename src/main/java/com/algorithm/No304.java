package com.algorithm;

/**
 * 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2) 。
 * 上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。
 * Created by leng on 2021/03/02.
 */
public class No304 {

}

class NumMatrix {

    private int[][] sums;
    //二维前缀和
    public NumMatrix(int[][] matrix) {
        int row_length = matrix.length;
        if(row_length>0) {
            int column_length = matrix[0].length;
            sums = new int[row_length + 1][column_length + 1];
            for (int i = 0; i < row_length; i++) {
                for (int j = 0; j < column_length; j++) {
                    sums[i + 1][j + 1] = sums[i][j + 1] + sums[i + 1][j] - sums[i][j] + matrix[i][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sums[row2+1][col2+1]+sums[row1][col1]-sums[row1][col2+1]-sums[row2+1][col1];
    }
}