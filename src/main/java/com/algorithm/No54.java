package com.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * Created by leng on 2021/03/15.
 */
public class No54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<Integer>();
        //为空 返回空数组
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int rows = matrix.length, columns = matrix[0].length;
        //创建存储访问状态的矩阵
        boolean[][] visited = new boolean[rows][columns];
        int total = rows * columns;
        int row = 0, column = 0;
        //遍历改变方向的矩阵
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        for (int i = 0; i < total; i++) {
            order.add(matrix[row][column]);
            visited[row][column] = true;
            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
            //超过边界或者访问过 改变方向
            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }
        return order;
    }
    public List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> order = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        //循环条件:下一层存在
        while (left <= right && top <= bottom) {
            //遍历顶行
            for (int column = left; column <= right; column++) {
                order.add(matrix[top][column]);
            }
            //遍历右列
            for (int row = top + 1; row <= bottom; row++) {
                order.add(matrix[row][right]);
            }
            //如果底行 左列存在
            if (left < right && top < bottom) {
                //遍历底行
                for (int column = right - 1; column > left; column--) {
                    order.add(matrix[bottom][column]);
                }
                //遍历左列
                for (int row = bottom; row > top; row--) {
                    order.add(matrix[row][left]);
                }
            }
            //进入下一层
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }

    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> ans=new ArrayList<>();
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return ans;
        }
        int rows=matrix.length,cols=matrix[0].length;
        int top=0,right=cols-1,bottom=rows-1,left=0;
        int i;
        while(top<=bottom&&left<=right){
            for(i=left;i<=right;i++){
                ans.add(matrix[top][i]);
            }
            for(i=top+1;i<=bottom;i++){
                ans.add(matrix[i][right]);
            }
            if(top<bottom&&left<right){
                for(i=right-1;i>=left;i--){
                    ans.add(matrix[bottom][i]);
                }
                for(i=bottom-1;i>top;i--){
                    ans.add(matrix[i][left]);
                }
            }
            top++;
            bottom--;
            left++;
            right--;
        }
        return ans;
    }
}
