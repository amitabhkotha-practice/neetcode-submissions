class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);
        for(int stone: stones) {
            maxHeap.offer(stone);
        }

        while(maxHeap.size() > 1) {
            int first = maxHeap.poll();
            int second = maxHeap.poll();
            if(second < first) {
                maxHeap.offer(first - second);
            }
        }
        maxHeap.offer(0);
        return maxHeap.poll();
    }
}
