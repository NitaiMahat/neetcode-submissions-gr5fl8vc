class TimeMap {
    private Map<String,ArrayList<Node>> hashMap;
    public TimeMap() {
        hashMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!hashMap.containsKey(key)){
            hashMap.put(key,new ArrayList<>());
           
        }
         hashMap.get(key).add(new Node(value,timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!hashMap.containsKey(key)){
            return "";
        }
        List<Node> temp = hashMap.get(key);
        int left = 0;
        int right = temp.size()-1;
        String ans = "";
        while(left<=right){
            int mid = left+ (right-left)/2;
            Node node = temp.get(mid);
            if(node.timestamp <= timestamp){
                ans = node.value;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return ans;
    }
}
class Node{
    private int timestamp;
    private String value;
    public Node(String value, int timestamp){
        this.timestamp = timestamp;
        this.value = value;
    }
}
