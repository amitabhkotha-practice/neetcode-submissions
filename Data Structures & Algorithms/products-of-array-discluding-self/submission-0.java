class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] pre = new int[n], pos = new int[n];

        pre[0] = nums[0];
        pos[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] * nums[i];
        }

        for (int i = n - 2; i >= 0; i--) {
            pos[i] = pos[i + 1] * nums[i];
        }

        // System.out.println(Arrays.toString(pre));
        // System.out.println(Arrays.toString(pos));

        for(int i = 0; i < n; i++) {
            int left = i > 0 ? pre[i - 1] : 1;
            int right = i < n - 1 ? pos[i + 1] : 1;
            ans[i] = left * right;
        }
        return ans;
    }
}
