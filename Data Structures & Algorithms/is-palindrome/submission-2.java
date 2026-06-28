class Solution {
    public boolean isPalindrome(String s) {
        s = s.trim();
        char[] arr = s.toCharArray();
        int n = arr.length;
        int l = 0, r = n - 1;
        while(l <= r) {
            while(l < n && !Character.isLetterOrDigit(arr[l]))
                l++;
            while(r >= 0 && !Character.isLetterOrDigit(arr[r]))
                r--;
            
            if(l < n && r >= 0 && Character.toLowerCase(arr[l]) != Character.toLowerCase(arr[r]))
                return false;
            
            l++;
            r--;
        }

        return true;
    }
}
