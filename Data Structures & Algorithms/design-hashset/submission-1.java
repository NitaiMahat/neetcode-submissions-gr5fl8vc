class MyHashSet {
    List<Integer> keySet;
    List<Integer> seenSet;

    public MyHashSet() {
        keySet = new ArrayList<>();
        seenSet = new ArrayList<>();
    }
    
    public void add(int key) {
        if(!keySet.contains(key)){
            keySet.add(key);
        }
    }
    
    public void remove(int key) {
        keySet.remove(Integer.valueOf(key));
        
    }
    
    public boolean contains(int key) {
        return keySet.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */