class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a,b) -> b-a);
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty() || maxHeap.peek() >= num){
            maxHeap.add(num);
        }else{
            minHeap.add(num);
        }

        if(maxHeap.size() > minHeap.size()+1){
            minHeap.add(maxHeap.poll());
        }else if(minHeap.size() > maxHeap.size()+1){
            maxHeap.add(minHeap.poll());
        }
        
    }
    
    public double findMedian() {
        if(maxHeap.size()==minHeap.size()){
            return (double)( (maxHeap.peek() + minHeap.peek()) / 2.0);
        }
        if(maxHeap.size()>minHeap.size()){
            return maxHeap.peek();
        }
        return minHeap.peek();
    }
}
