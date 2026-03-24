class Solution {
    public long maxRunTime(int n, int[] batteries) {
        // 3 3 3 
        // 2 2 3
        // 2 1 2
        // 1 1 1
        // 0 0 1
        long sum = 0;
        for(int battery: batteries)
            sum+=battery;

        long left = 0, right = sum/n;
        while(left<right){
            long mid = left + (right-left)/2 +1;

            if(canRunFor(batteries, n, mid))
                left = mid;
            else    
                right = mid -1;

        }
        return left;

    }
    public boolean canRunFor(int[] batteries, int comNum, long time){
        long usefulMinutes = 0;

        for(int battery: batteries){
            usefulMinutes += Math.min(battery, time);
            if(usefulMinutes>=comNum*time)
                return true;
        }
        return false;

    }
}