class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int[] meetingCount = new int[n];
        long[] availableTime = new long[n];

        Arrays.sort(meetings, (a,b)->a[0]-b[0]);

        for(int[] meeting: meetings){
            int start = meeting[0], end = meeting[1];
            long minAvailableTime = Long.MAX_VALUE;
            int minidx = -1;
            boolean roomFound=false;
            for(int j=0;j<n;j++){
                if(availableTime[j]<=start){
                    roomFound = true;
                    meetingCount[j]++;
                    availableTime[j] = end;
                    break;
                }
                if(availableTime[j] < minAvailableTime){
                    minAvailableTime = availableTime[j];
                    minidx = j;
                }
            }
            if(!roomFound){
                meetingCount[minidx]++;
                availableTime[minidx]+= end-start;
            }
        }   

        int maxMeetings = 0;
        int maxidx = -1;
        for(int i=0;i<n;i++){
            if(meetingCount[i] > maxMeetings){
                maxMeetings = meetingCount[i];
                maxidx = i;
            }
        }
        return maxidx;
    }
}