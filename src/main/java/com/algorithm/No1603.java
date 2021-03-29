package com.algorithm;

/**
 * 请你给一个停车场设计一个停车系统。停车场总共有三种不同大小的车位：大，中和小，每种尺寸分别有固定数目的车位。
 *
 * 请你实现 ParkingSystem 类：
 *
 * ParkingSystem(int big, int medium, int small) 初始化 ParkingSystem 类，三个参数分别对应每种停车位的数目。
 * bool addCar(int carType) 检查是否有 carType 对应的停车位。 carType 有三种类型：大，中，小，分别用数字 1， 2 和 3 表示。一辆车只能停在  carType 对应尺寸的停车位中。如果没有空车位，请返回 false ，否则将该车停入车位并返回 true 。
 *  
 * Created by leng on 2021/03/19.
 */
public class No1603 {
    public static void main(String[] args) {
        System.out.println(2|2);
    }
}

class ParkingSystem {
    //前十位存big的剩余数 中十位存medium的总数 后十位存small的总数
    int count;
    public ParkingSystem(int big, int medium, int small) {
        count=(small<<20|medium<<10|big);
    }

    public boolean addCar(int carType) {
        int bit=(carType-1)*10;
        if(((count>>bit)&0b1111111111)<=0){
            return false;
        }
        count-=1<<bit;
        return true;
    }
}