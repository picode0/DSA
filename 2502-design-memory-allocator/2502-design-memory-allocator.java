class Allocator {
    //Map<Integer, List<Integer>> map;
    int[] alloc;
    public Allocator(int n) {
        //map = new HashMap<>();
        alloc = new int[n];
    }
    
    public int allocate(int size, int mID) {
        //int idx = 0;
        int cnt = 0;
        for(int i=0;i<alloc.length;i++){
            if(alloc[i]==0){
                if(++cnt==size){
                    //System.out.println(size + " i " + i + " w " + (i-cnt-1));
                    fill(alloc, i-cnt+1, size, mID);
                    return i-cnt+1;
                };
            }
            else    
                cnt =0;
        }
        return -1;
    }
    
    public int freeMemory(int mID) {
        int cnt = 0;
        for(int i=0;i<alloc.length;i++){
            if(alloc[i] == mID){
                alloc[i] = 0;
                cnt++;
            }
        }
        return cnt;
    }

    public void fill(int[] alloc, int startIdx, int size, int val){
        for(int i=startIdx;i<startIdx+size;i++)
            alloc[i] = val;
    }
}

/**
 * Your Allocator object will be instantiated and called as such:
 * Allocator obj = new Allocator(n);
 * int param_1 = obj.allocate(size,mID);
 * int param_2 = obj.freeMemory(mID);
 */