class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        //int[] landEndTime = new int[landStartTime.length];
        int minLandEndTime = Integer.MAX_VALUE;
        int minWaterEndTime = Integer.MAX_VALUE;

        for(int i=0;i<landStartTime.length;i++)
            minLandEndTime = Math.min(minLandEndTime, landStartTime[i]+landDuration[i]);

        for(int i=0;i<waterStartTime.length;i++)
            minWaterEndTime = Math.min(minWaterEndTime, waterStartTime[i]+waterDuration[i]);

        

        int ret = Integer.MAX_VALUE;
        for(int i=0;i<waterStartTime.length;i++){
            if(waterStartTime[i]<=minLandEndTime)
                ret = Math.min(ret, minLandEndTime + waterDuration[i]);
            else    
                ret = Math.min(ret, waterStartTime[i] + waterDuration[i]);
        }

        for(int i=0;i<landStartTime.length;i++){
            if(landStartTime[i]<=minWaterEndTime)
                ret = Math.min(ret, minWaterEndTime + landDuration[i]);
            else 
                ret = Math.min(ret, landStartTime[i] + landDuration[i]);
        }

        return ret;
    }
}