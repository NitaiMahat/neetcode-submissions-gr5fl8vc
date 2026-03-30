class TimeMap {
    private Map<String,ArrayList<Node>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key, new ArrayList<>());
        }
        ArrayList<Node> temp = map.get(key);
        temp.add(new Node(value,timestamp));
        
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }
        ArrayList<Node> temp = map.get(key);
        int left = 0;
        int right = temp.size()-1;
        String ans = "";
        while(left<=right){
            int mid = left + (right-left)/2;
            Node nodes = temp.get(mid);
            if(nodes.time <=timestamp){
                ans = nodes.val;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return ans;
        
    }

   
}
public class Node{
    private int time;
    private String val;
    public Node(String val,int time){
        this.val = val;
        this.time = time;
    }
}
