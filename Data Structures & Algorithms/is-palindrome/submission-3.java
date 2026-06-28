class Solution {
    public boolean isPalindrome(String s) {
        String str = s.toLowerCase();
        int l = 0;
        int r = str.length() - 1;
        while (l < r) {
            while (!Character.isLetterOrDigit(str.charAt(l)) && l < r) l++;
            while (!Character.isLetterOrDigit(str.charAt(r)) && r > l) r--;

            if (str.charAt(l) != str.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}
