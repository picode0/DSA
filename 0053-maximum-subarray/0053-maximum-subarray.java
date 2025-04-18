class Solution {
    public int maxSubArray(int[] nums) {
        int currentSubarray = nums[0];
        int maxSubarray = nums[0];

        for(int i =1; i< nums.length;i++){
            int num = nums[i];
            currentSubarray = Math.max(num, currentSubarray+num);
            maxSubarray = Math.max(maxSubarray, currentSubarray);
        }
        return maxSubarray;
    }
    // O(n)Time Complexity 
/*
    public int findBestSubArray(int[] nums, int left, int right){
        if(left>right)
            return Integer.MIN_VALUE; 
        
        int mid = left + (right-left)/2 + 1;
        int curr = 0; 
        int leftsum = 0; 
        int rightsum = 0; 

        for(int i = mid-1; i>=left; i--){
            curr += nums[i];
            leftsum = Math.max(leftsum, curr);
        }

        curr = 0; 
        for(int i = mid +1; i<=right;i++){
            curr += nums[i];
            rightsum = Math.max(rightsum, curr);
        }
        int combinedSum = nums[mid] + leftsum + rightsum;
        int leftHalf = findBestSubArray(nums, left, mid-1);
        int rightHalf = findBestSubArray(nums, mid+1, right);

        return Math.max(combineSum,  Math.max(leftHalf, rightHalf) );
        // O(n log n)
    }
    */
}