class Node{
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int key,int val){
            this.key = key;
            this.val = val;
            prev = null;
            next = null;
        }

    }
class LRUCache {
    int capacity;
    Map<Integer,Node> cache;
    Node head;
    Node tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;

    }
    public void addFront(Node curr){
        curr.next = head.next;
        head.next.prev = curr;
        curr.prev = head;
        head.next = curr;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            Node temp = cache.get(key);
            //----remove node----
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
             //----remove node----
            addFront(temp);
            return temp.val;
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            
            Node temp = cache.get(key);
            //----remove node----
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
             //----remove node----
            temp.val = value;
            addFront(temp);
        }else{
            if(cache.size() >=capacity){
                Node tempLru = tail.prev;
                 //----remove node----
                tempLru.prev.next = tempLru.next;
                tempLru.next.prev = tempLru.prev;
                 //----remove node----
                 cache.remove(tempLru.key);
                
            }
            Node newNode1 = new Node(key,value);
            addFront(newNode1);
            cache.put(key,newNode1);

        }
    }
}
