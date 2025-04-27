class Solution {
    public int maximumTastiness(int[] price, int k) {
        // 16 28 63 85 159 168 200
        Arrays.sort(price);

        int left = 0, right = price[price.length-1] - price[0];
        while(left<right){
            int mid = left + (right-left)/2 +1;
            if(tastinessWith(price, k, mid)){
                left = mid;
            }
            else{
                right = mid - 1;
            }
        }
        return left;
    }

    public boolean tastinessWith(int[] price, int k, int val){
        int start = price[0];
        int cnt = 1;
        for(int i=1;i<price.length;i++){
            if(price[i] >= start + val){
                start = price[i];
                cnt++;
            }
        }
        return cnt>=k;
    }
}