class LRUCache {
    private int capacity;
    private Map<Integer,ListNode> cache;
    private LinkedList<ListNode> lruList;
    private class ListNode{
        int key;
        int value;
        public ListNode(int key,int value){
            this.key = key;
            this.value = value;
        }
    }
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        lruList = new LinkedList<>();
        
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            ListNode node = cache.get(key);
            lruList.remove(node);
            lruList.addFirst(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            ListNode node2 = cache.get(key);
            lruList.remove(node2);
            node2.value = value;
            lruList.addFirst(node2);
        }else{
            if(cache.size() >=capacity){
                ListNode removeNode = lruList.removeLast();
                cache.remove(removeNode.key);
            }
            ListNode newNode = new ListNode(key,value);
            lruList.addFirst(newNode);
            cache.put(key,newNode);
        }
    }
}
