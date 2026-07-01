class FreqStack {
    Map<Integer,Integer> freq;
    Map<Integer, Stack<Integer>> freqStack;
    int maxfreq;
    public FreqStack() {
        freq = new HashMap<>();  
        freqStack = new HashMap<>();
        maxfreq = 0;
    }
    
    public void push(int val) {
        int f = freq.getOrDefault(val, 0)+1;
        if(f>maxfreq)
            maxfreq = f;
        freq.put(val, f);
        freqStack.putIfAbsent(f, new Stack<>());
        freqStack.get(f).push(val);
    }
    
    public int pop() {
        int val = freqStack.get(maxfreq).pop();
        freq.put(val, freq.get(val)-1);
        if(freqStack.get(maxfreq).size()==0)
            maxfreq--;
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */