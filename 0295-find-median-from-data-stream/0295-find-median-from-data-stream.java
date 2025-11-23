class MedianFinder {
    PriorityQueue<Integer> maxH;
    PriorityQueue<Integer> minH;
    public MedianFinder() {
        minH = new PriorityQueue<>((a,b)->b-a);
        maxH = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(minH.isEmpty() || minH.peek()>num)
            minH.offer(num);
        else 
            maxH.offer(num);

        if(minH.size() > maxH.size()+1)
            maxH.offer(minH.poll());
        else if(maxH.size() > minH.size())
            minH.offer(maxH.poll());
        
    }
    
    public double findMedian() {
        if(maxH.size() == minH.size())
            return (double)(maxH.peek() + minH.peek())/2;
        else
            return (double)minH.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */