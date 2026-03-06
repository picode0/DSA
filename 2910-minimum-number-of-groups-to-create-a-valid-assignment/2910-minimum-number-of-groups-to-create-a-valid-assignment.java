class Solution {
    public int minGroupsForValidAssignment(int[] balls) {
        // 1 2 3

        // 5 4 3
        Map<Integer,Integer> freq = new HashMap<>();

        for(int ballNum:balls){
            freq.put(ballNum, freq.getOrDefault(ballNum, 0)+1);
        } 

        int minFreq  = balls.length;

        for(int val: freq.values())
            minFreq = Math.min(minFreq, val);

        for(int i=minFreq;i>=1;i--){
            int howManyGroups = numGroup(freq, i);
            if(howManyGroups>0)
                return howManyGroups;
        }
        // 7 -> 2 2 3  -> 3 3 1 
        return balls.length;

    }
    public int numGroup(Map<Integer,Integer> freq, int size){
        int largerSize = size+1;

        int ret = 0;
        for(int val: freq.values()){
            int num = val / largerSize;
            int remaining = val % largerSize;

            if(remaining==0)
                ret+=num;
            else if(size-remaining <= num){
                ret+=num+1;
            }
            else return 0;
        }
        return ret;
    }
}