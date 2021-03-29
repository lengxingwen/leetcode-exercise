package com.algorithm;

/**
 * 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
 * Created by leng on 2021/02/27.
 */
public class No395 {
    public int longestSubstring(String s, int k) {
        int n = s.length();
        return dfs(s, 0, n - 1, k);
    }

    public int dfs(String s, int l, int r, int k) {
        int[] cnt = new int[26];
        for (int i = l; i <= r; i++) {
            cnt[s.charAt(i) - 'a']++;
        }

        char split = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0 && cnt[i] < k) {
                split = (char) (i + 'a');
                break;
            }
        }
        //所有字符出现次数>=k
        if (split == 0) {
            return r - l + 1;
        }

        int i = l;
        int ret = 0;
        while (i <= r) {
            while (i <= r && s.charAt(i) == split) {
                i++;
            }
            if (i > r) {
                break;
            }
            int start = i;
            while (i <= r && s.charAt(i) != split) {
                i++;
            }

            int length = dfs(s, start, i - 1, k);
            ret = Math.max(ret, length);
        }
        return ret;
    }

    //滑动窗口
    public int longestSubstring1(String s, int k) {
        int ret = 0;
        int n = s.length();
        // 统计26中type ，多种type的字符数量
        for (int t = 0; t <= 26; t++) {
            int l = 0,r = 0;
            // cnt统计每个字符出现的次数
            int[] cnt = new int[26];
            // 字符种类
            int tot = 0;
            // 计数器当前出现次数小于k的字符的数量
            int less = 0;
            while (r<n){
                cnt[s.charAt(r) - 'a']++;
                if (cnt[s.charAt(r) - 'a'] == 1){
                    // 第一次出现某个字符，种类+1
                    tot++;
                    // 且less与k的种类也+1
                    less++;
                }
                if (cnt[s.charAt(r) - 'a'] == k){
                    // 出现的字符数第一次累计到符合条件的k个，说明不满足的种类自减
                    less--;
                }
                // 超出预定的种类,右移左边界并且更新种类数量，知道符合统计规律
                while (tot > t){
                    cnt[s.charAt(l) - 'a']--;
                    if (cnt[s.charAt(l) - 'a'] == k-1){
                        less++;
                    }
                    if (cnt[s.charAt(l) - 'a'] == 0){
                        // 某一种字符计数为空
                        tot--;
                        less--;
                    }
                    l++;
                }
                if (less == 0) {
                    // 有多种类型且每种类型都超过预定k个
                    ret = Math.max(ret,r-l+1);
                }
                r++;
            }
        }
        return ret;
    }
}
