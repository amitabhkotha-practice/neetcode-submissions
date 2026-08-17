class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while(n > 0) {
            int digit = (n & 1);
            n >>= 1;
            if(digit == 1)
                count++;
        }
        return count;
    }
}
