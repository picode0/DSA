class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[] gaps = new int[n+1];
        int retval = 0;


        gaps[0]  = startTime[0];
        for(int i=1;i<n;i++){
            gaps[i] = startTime[i] - endTime[i-1];
        }
        gaps[n] = eventTime - endTime[n-1];

        int[] rightlargestgap = new int[n+1];
    
        for(int i=n-1;i>=0;i--){
            rightlargestgap[i] = Math.max(rightlargestgap[i+1], gaps[i+1]);
        }

        int lmaxgap = 0;

        for(int i=1;i<=n;i++){
            int eventlength = endTime[i-1] - startTime[i-1];
            boolean canfitleft = lmaxgap >= eventlength;
            boolean canfitright = rightlargestgap[i] >= eventlength;
            if(canfitleft || canfitright){
                int merged = gaps[i]+gaps[i-1] + eventlength;
                retval = Math.max(retval, merged); 
            }
            
            retval = Math.max(retval, gaps[i] + gaps[i-1]);
            lmaxgap = Math.max(lmaxgap, gaps[i-1]);
        }   
        return retval;





    }
}