class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for (int x : nums) freq.put(x, freq.getOrDefault(x, 0) + 1);

        List<int[]> arr = new ArrayList<>();
        for (int key : freq.keySet()) {
            int value = freq.get(key);
            arr.add(new int[] {value, key});
        }

        arr.sort((a, b) -> b[0] - a[0]);

        int[] result = new int[k];
        for(int i = 0; i < k; i++) {
            result[i] = arr.get(i)[1];
        }
        return result;
    }
}
