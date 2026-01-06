class Solution {
    public void nextPermutation(int[] nums) {
        // 3 2 1 
        // 
        // 1 3 2 4 
        // 1 4 3 2 
        // 2 1 3 4 
        int firstIncreasing = nums.length - 2;
        while(firstIncreasing>=0 && nums[firstIncreasing] >= nums[firstIncreasing+1])
            firstIncreasing--;

        if(firstIncreasing>=0){
            int nextGreater = nums.length-1;
            while(nextGreater>=0 && nums[nextGreater]<=nums[firstIncreasing]){
                nextGreater--;
            }
            swap(nums, firstIncreasing, nextGreater);
        }  
        reverse(nums, firstIncreasing+1);


    }

    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public void reverse(int[] nums, int start){
        int left = start, right = nums.length - 1;

        while(left<right){
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}