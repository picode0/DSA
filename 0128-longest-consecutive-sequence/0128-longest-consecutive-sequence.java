class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ret = 0 ;
        for(int num: nums){
            set.add(num);
        }

        for(int num: set){
            if(!set.contains(num-1)){
                int cnt = 1;
                int curr = num;
                while(set.contains(++curr))
                    cnt++;
                ret = Math.max(ret,cnt);
            }
        }
        return ret;

    }
}