class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // -4 -1 1 2

        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        for(int i=0;i<nums.length-2;i++){
            int left = i+1;
            int right = nums.length-1;

            while(left<right){
                int sum = nums[i] + nums[left] + nums[right];
                if(Math.abs(target-sum) < Math.abs(minDiff))
                    minDiff = target-sum;

                if(target > sum)
                    left++;
                else
                    right--;
            }


        }
        return target-minDiff;
    }
}