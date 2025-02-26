package Skillrack.Longest_Awesome_Substring;

import java.util.HashMap;


class Solution {
    public int longestAwesome(String s) {
        return util1(s);
    }
    // brain melt
    public int util1(String str) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1);
        int mask = 0, ans = 0;
        for (int i = 0; i < str.length(); i++) {
            mask = mask ^ (1 << (str.charAt(i) - '0'));
            // if this conditions comes, that means every number in between has come even
            // number of times
            if (hm.containsKey(mask)) {
                ans = Math.max(ans, (i - hm.get(mask)));
            } else {
                hm.put(mask, i);
            }
            // if the below conditions work, we know that that only one is odd, rest all
            // were even
            for (int j = 0; j < 10; j++) {
                int newMask = mask ^ (1 << j);
                if (hm.containsKey(newMask)) {
                    ans = Math.max(ans, (i - hm.get(newMask)));
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestAwesome("1123"));
    }
}