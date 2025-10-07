class Solution {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        TreeSet<Integer> set = new TreeSet<>();
        int ret = Integer.MAX_VALUE;
        for(int i=x;i<nums.size();i++){
            set.add(nums.get(i-x));
            Integer high = set.ceiling(nums.get(i));
            Integer low = set.floor(nums.get(i));

            if(high!=null)
                ret = Math.min(ret, Math.abs(nums.get(i)-high));
            if(low!=null)
                ret = Math.min(ret, Math.abs(nums.get(i)-low));


        }
        return ret;
    }
}