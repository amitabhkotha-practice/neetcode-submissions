class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int n = prices.length;
        int l = 0;
        for(int r = 1; r < n; r++) {
            while(prices[l] > prices[r]) {
                l++;
            }
            max = Math.max(prices[r] - prices[l], max);
        }

        return max;
    }
}
