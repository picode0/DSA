class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        List<Integer> list = new ArrayList<>();
        int n = startTime.length;
        if(startTime[0] != 0)
            list.add(startTime[0]);

        for(int i=1;i<n;i++){
            list.add(startTime[i] - endTime[i-1]);
        }

        if(eventTime - endTime[n-1] !=0 )
            list.add(eventTime-endTime[n-1]);

        if(list.size()==1)
            return list.get(0);

        int left = 0;
        int sum=0;
        int retval = 0;
        for(int right=0;right<list.size();right++){
            sum+=list.get(right);
            if(right-left+1==k+1){
                retval = Math.max(retval, sum);
                sum-= list.get(left++);
            }
        }
        return retval==0?sum:retval;
        // 0   7 - 10  10 - 14  16-18  21
        // 7  0 2  3
    }
}