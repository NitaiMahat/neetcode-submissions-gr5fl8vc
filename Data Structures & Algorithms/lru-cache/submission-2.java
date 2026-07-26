class Node{
    int val;
    int key;
    public Node(int key,int val){
        this.key = key;
        this.val = val;
    }
}
class LRUCache {
    int capacity;
    Map<Integer,Node> cache;
    Deque<Node> lruList; 
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        lruList = new ArrayDeque<>();
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)){
            return -1;
        }else{
            
            Node removedNode = cache.get(key);
              lruList.remove(removedNode);
            lruList.addFirst(removedNode);
            return removedNode.val;
        }
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Node keyNode = cache.get(key);
            lruList.remove(keyNode);
            keyNode.val = value;
            
            lruList.addFirst(keyNode);
        }else{
            if(capacity ==cache.size()){
                Node removeNode = lruList.pollLast();
                cache.remove(removeNode.key);
            }
            Node newNode = new Node(key,value);
            cache.put(key,newNode);
            lruList.addFirst(newNode);
        }
    }
}
