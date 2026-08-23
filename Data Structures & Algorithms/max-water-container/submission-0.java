class Solution {
    public int maxArea(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int maxArea = 0;
        while (left < right) {
            int width = right - left;
            int height = Math.min(nums[right], nums[left]);
            maxArea = Math.max(maxArea, width * height);

            if (nums[left] < nums[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }
}
