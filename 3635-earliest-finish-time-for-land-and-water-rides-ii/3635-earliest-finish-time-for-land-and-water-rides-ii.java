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
            ret = Math.min(ret, Math.max(minLandEndTime, waterStartTime[i])+waterDuration[i]);
        }

        for(int i=0;i<landStartTime.length;i++){
            ret = Math.min(ret, Math.max(minWaterEndTime, landStartTime[i])+landDuration[i]);
        }

        return ret;
    }
}