class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = 0;
        for(int num:nums)
            max = Math.max(num,max);

        int left = 1, right = max;
        while(left<right){
            int mid = left + (right-left)/2;
            if(result(nums,mid)>threshold)
                left = mid + 1;
            else
                right = mid;
        }
        return left;


    }

    public int result(int[] nums, int divisor){
        int sum = 0;
        for(int num:nums){
            sum+=(num/divisor);
            if(num%divisor !=0)
                sum++;
        }
        return sum;
    }
}