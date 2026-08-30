class TimeMap {
    private Map<String, TreeMap<Integer, String>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new TreeMap<Integer, String>()).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key))
            return "";
        
        TreeMap<Integer, String> timestampMap = map.get(key);
        var entry = timestampMap.floorEntry(timestamp);
        return entry == null ? "" : entry.getValue();
    }
}
/**

Structure
Map<Key, Value> -> 
    Key will be key string directly
    Value must be Map<TimeStamp, >

*/