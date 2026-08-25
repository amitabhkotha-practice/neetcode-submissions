class Solution {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        int n = nums.length;
        if(n == 1)
            return nums[0];
        int left = 0;
        int right = n - 1;

        while(left <= right) {
            int mid = left + ((right - left) / 2);
            min = Math.min(min, nums[mid]);
            if(nums[mid] < nums[right]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return min;
    }
}
