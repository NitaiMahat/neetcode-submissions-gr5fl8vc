class TimeMap {
    Map<String,ArrayList<Node>> keyMap;
    public TimeMap() {
        keyMap = new HashMap<>();
        
    }
    
    public void set(String key, String value, int timestamp) {
        if(!keyMap.containsKey(key)){
            keyMap.put(key, new ArrayList<>());
        }
        ArrayList<Node> list = keyMap.get(key);
       list.add(new Node(value,timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!keyMap.containsKey(key)){
            return "";
        }
        ArrayList<Node> list = keyMap.get(key);
        int left = 0;
        int right = list.size()-1;
        String ans = "";
        while(left<=right){
            int mid = left + (right-left)/2;
            Node node = list.get(mid);
            if(node.time <=timestamp){
                ans = node.value;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return ans;
        
    }
}
class Node {
    private String value;
    private int time;
    public Node(String value,int time){
        this.value = value;
        this.time = time;
    }
}
