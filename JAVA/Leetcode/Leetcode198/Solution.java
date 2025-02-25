package Leetcode.Leetcode198;

public class Solution {

    public int rob(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[0] + nums[2];
        for (int i = 3; i < len; i++) {
            int max = Math.max(dp[i - 2], dp[i - 3]);
            dp[i] = nums[i] + max;
        }
        return Math.max(dp[len - 1], dp[len - 2]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 2, 1, 1, 2 };
        int ans = solution.rob(nums);
        System.out.println(ans);
    }
}