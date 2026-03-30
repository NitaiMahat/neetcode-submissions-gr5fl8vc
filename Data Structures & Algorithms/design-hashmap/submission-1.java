class MyHashMap {
    List<Integer> keySet;
    List<Integer> valueSet;
   

    public MyHashMap() {
        keySet = new ArrayList<>();
        valueSet = new ArrayList<>();
      
    }
    
    public void put(int key, int value) {
        if(!keySet.contains(key)){
            keySet.add(key);
            valueSet.add(value);
        }else{
            int indexOfValue = keySet.indexOf(key);
            valueSet.set(indexOfValue,value);
        }
    }
    
    public int get(int key) {
        if(!keySet.contains(key)){
            return -1;
        }else{
            return valueSet.get(keySet.indexOf(key));
        }
    }
    
    public void remove(int key) {
        if(keySet.contains(key)){
                 valueSet.remove(keySet.indexOf(key));
                 keySet.remove(Integer.valueOf(key));
        }
   
        
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */