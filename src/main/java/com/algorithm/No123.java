package com.algorithm;

/**
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * Created by leng on 2021/01/09.
 */
public class No123 {
    //动态规划 实际求数组最大的两无交叉峰谷差之和
    public int maxProfit(int[] prices) {
        int n = prices.length;
        //第一笔买入卖出
        int buy1 = -prices[0], sell1 = 0;
        //第二笔买入卖出
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < n; ++i) {
            //第i天第一笔买入的最小负债
            buy1 = Math.max(buy1, -prices[i]);
            //第i天第一笔卖出的最大收益
            sell1 = Math.max(sell1, buy1 + prices[i]);
            //第i天第二笔买入的最小负债
            buy2 = Math.max(buy2, sell1 - prices[i]);
            //第i天第二笔卖出的最大收益
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }

    public int maxProfit1(int[] prices) {
        int buy1=-prices[0],buy2=-prices[0],sell1=0,sell2=0;
        for (int i = 1; i < prices.length; i++) {
            buy1=Math.max(buy1,-prices[i]);
            sell1=Math.max(sell1,buy1+prices[i]);
            buy2=Math.max(buy2,sell1-prices[i]);
            sell2=Math.max(sell2,buy2+prices[i]);
        }
        return sell2;
    }
}
