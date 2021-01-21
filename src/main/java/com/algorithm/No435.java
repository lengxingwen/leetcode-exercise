package com.algorithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 *  * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 *  * 注意:
 *  * 可以认为区间的终点总是大于它的起点。
 *  * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * Created by leng on 2020/12/31.
 */
public class No435 {
    //贪心
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                //比较每个区间的右端点 升序
                return interval1[1] - interval2[1];
            }
        });

        int n = intervals.length;
        //维护第一个区间的右端点
        int right = intervals[0][1];
        int ans = 1;
        for (int i = 1; i < n; ++i) {
            //当遍历的左端点大于上个区间的右端点时 不重叠区间数+1 维护此区间右端点的值
            if (intervals[i][0] >= right) {
                ++ans;
                right = intervals[i][1];
            }
        }
        return n - ans;
    }

    //动态规划
    public int eraseOverlapIntervals1(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                //比较每个区间的左端点 升序排列
                return interval1[0] - interval2[0];
            }
        });

        int n = intervals.length;
        int[] f = new int[n];
        //f[i]都至少包含自己这一个区间 数量至少为1
        Arrays.fill(f, 1);
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                //j区间不与i区间重叠
                if (intervals[j][1] <= intervals[i][0]) {
                    //状态转移
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }
        //返回f最大值
        return n - Arrays.stream(f).max().getAsInt();
    }
}
