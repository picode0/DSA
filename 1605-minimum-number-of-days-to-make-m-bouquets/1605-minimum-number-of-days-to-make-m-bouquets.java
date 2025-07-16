class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        // 1  0
        // 2  4
        // 3  2
        // 10 1 3
        // 1 10 3 10 2
        if(bloomDay.length < (long)m*k)
            return -1;
        int max = 0;
        //int ret = 0;
        for(int num: bloomDay)
            max = Math.max(max, num);

        int left = 1, right = max;
        while(left<right){
            int mid = left + (right-left)/2;
            if(getBouquetNum(bloomDay, mid, k) >= m)
                right = mid;
            else
                left = mid +1;
        }

        return left; 

    }

    public int getBouquetNum(int[] bloomDay, int day, int k){
        int num = 0;

        int count = 0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i] <= day)
                count++;
            else
                count =0;
            
            if(count==k){
                num++;
                count = 0;
            }
        }
        return num;
    }
}