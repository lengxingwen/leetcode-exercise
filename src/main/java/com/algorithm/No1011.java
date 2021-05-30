package com.algorithm;

import java.util.Arrays;

/**
 * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 *
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 *
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 * Created by leng on 2021/04/26.
 */
public class No1011 {
    public int shipWithinDays(int[] weights, int D) {
        int total=0;
        int max=0;
        for (int a:weights
             ) {
            max=Math.max(max,a);
            total+=a;
        }
        while(max<total){
            int mid=(max+total)/2;
            int needDay=1;
            int load=0;
            for (int a:weights
                 ) {
                if(load+a>mid){
                    needDay++;
                    load=0;
                }
                load+=a;
            }
            if(needDay<=D){
                total=mid;
            }else {
                max=mid+1;
            }
        }
        return max;
    }

    public int shipWithinDays1(int[] weights, int D) {
        // 确定二分查找左右边界
        int left = Arrays.stream(weights).max().getAsInt(), right = Arrays.stream(weights).sum();
        while (left < right) {
            int mid = (left + right) / 2;
            // need 为需要运送的天数
            // cur 为当前这一天已经运送的包裹重量之和
            int need = 1, cur = 0;
            for (int weight : weights) {
                if (cur + weight > mid) {
                    ++need;
                    cur = 0;
                }
                cur += weight;
            }
            if (need <= D) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
