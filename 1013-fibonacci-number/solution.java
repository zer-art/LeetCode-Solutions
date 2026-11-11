class Solution {

    public int fib(int n) {
        if (n < 2) {
            return n;
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return helper(n, dp);
    }

    private int helper(int n, int[] dp) {
        if (n < 2) {
            return n;
        }
        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = helper(n - 1, dp) + helper(n - 2, dp);
        return dp[n];
    }
}
