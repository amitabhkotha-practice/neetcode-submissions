class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs) {
            String key = getAnagramString(s);
            map.computeIfAbsent(key, k -> new ArrayList<String>()).add(s);
        }
        for(var list: map.values()) {
            result.add(list);
        }
        return result;
    }

    private static String getAnagramString(String s) {
        int freq[] = new int[26];
        for(char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++) {
            if(freq[i] < 1) 
                continue;
            char c = (char)(97 + i);
            sb.append(c).append(freq[i]).append("#");
        }
        return sb.toString();
    }
}
