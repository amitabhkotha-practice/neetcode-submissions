class KthLargest {
    PriorityQueue<Integer> heap;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.heap = new PriorityQueue<Integer>();
        for(int x : nums) {
            this.heap.offer(x);
            if(this.heap.size() > k) {
                this.heap.poll();
            }
        }
    }
    
    public int add(int val) {
        this.heap.offer(val);
        if(this.heap.size() > k) {
            this.heap.poll();
        }
        return this.heap.peek();
    }
}
