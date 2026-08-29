class Solution {
    public int[] dailyTemperatures(int[] nums) {
        Stack<int[]> stack = new Stack<>();
        int n = nums.length;

        int[] result =  new int[n];
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && nums[i] > stack.peek()[0]) {
                int[] pair = stack.pop();
                result[pair[1]] = i - pair[1];
            }
            stack.push(new int[]{nums[i], i});
        }

        return result;
    }
}
