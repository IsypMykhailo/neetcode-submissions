class TimeMap {
    Map<String, List<List<Object>>> map;

    public TimeMap() {
        map = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            List<List<Object>> mapValue = new ArrayList();
            List<Object> pair = new ArrayList();
            pair.add(value);
            pair.add(timestamp);
            mapValue.add(pair);
            map.put(key, mapValue);
        } else {
            List<List<Object>> mapValue = map.get(key);
            List<Object> pair = new ArrayList();
            pair.add(value);
            pair.add(timestamp);
            mapValue.add(pair);
            map.put(key, mapValue);
        }
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        List<List<Object>> mapValue = map.get(key);
        int left = 0;
        int right = mapValue.size() - 1;
        List<Object> result = new ArrayList();
        result.add("");
        result.add(-1);
        while (left <= right) {
            int mid = (left + right) / 2;
            List<Object> midList = mapValue.get(mid);
            if ((int) midList.get(1) == timestamp) {
                return (String) midList.get(0);
            } else if ((int) midList.get(1) < timestamp && (int) result.get(1) < (int) midList.get(1)) {
                result.set(0, midList.get(0));
                result.set(1, midList.get(1));
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return (String) result.get(0);
    }
}
