class TimeMap {       
    private HashMap<String,ArrayList<Node>> timeMap;
    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!timeMap.containsKey(key)){
            timeMap.put(key,new ArrayList<>());
        }
        ArrayList<Node> timeValueList = timeMap.get(key);
        timeValueList.add(new Node(timestamp,value));
    }
    
    public String get(String key, int timestamp) {
        if(!timeMap.containsKey(key)){
            return "";
        }
        ArrayList<Node> list = timeMap.get(key);
        int left =0;
        int right = list.size()-1;
        String ans = "";
        while(left<=right){
            int mid = (left+right)/2;
            Node nodes = list.get(mid);
            
            if(nodes.time<= timestamp){
                ans= nodes.value;
                left = mid+1;
            }else{
                right = mid - 1;
            }
        }
        return ans;
    }
}

public class Node{
    private int time;
    private String value;

    public Node(int time,String value){
        this.time = time;
        this.value = value;
    }
}
