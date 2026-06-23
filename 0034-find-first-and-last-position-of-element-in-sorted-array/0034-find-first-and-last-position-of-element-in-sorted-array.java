class Solution {
    public int[] searchRange(int[] nums, int target) {
        //int[] ret = new int[2];
        //int first = findleftidx(nums, target);
        if(nums.length==0 || findleftidx(nums, target)==-1)
            return new int[] {-1,-1};
        else
            return new int[] {findleftidx(nums, target), findrightidx(nums, target)};
    }
    public int findleftidx(int[] nums, int target){
        int left=0, right=nums.length-1;
        while(left<right){
            int mid = left+(right-left)/2;
            if(nums[mid]<target)
                left = mid+1;
            else{
                right = mid;
            }
        }
        //System.out.println(left);
        return nums[left]==target?left:-1;
    }
    public int findrightidx(int[] nums, int target){
        int left=0, right=nums.length-1;
        while(left<right){
            int mid = left+(right-left)/2 +1;
            if(nums[mid]>target)
                right = mid-1;
            else{
                left = mid;
            }
        }
        return nums[right]==target?right:-1;
    }
}