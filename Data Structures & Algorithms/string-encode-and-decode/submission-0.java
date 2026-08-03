class Solution {
    private static final char DL = '#';
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append(DL).append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return result;
        }

        int i = 0;
        int n = str.length();
        while (i < n) {
            int j = i;
            while (str.charAt(j) != DL) {
                j++;
            }
            int len = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = i + len;
            result.add(str.substring(i, j));
            i = j;
        }
        return result;
    }
}
