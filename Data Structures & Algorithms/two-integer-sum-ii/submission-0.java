class Solution {
    public int[] twoSum(int[] arr, int target) {
        int ans[] = new int[2];

        int l = 0, r = arr.length - 1;

        while (l < r) {
            int sum = arr[l] + arr[r];
            if (sum == target)
                return new int[] {l + 1, r + 1};
            else if (sum > target)
                r--;
            else
                l++;
        }
        return ans;
    }
}
