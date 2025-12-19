class Solution {
    public int specialTriplets(int[] nums) {
        // 2 6 5 6 3 6 7 6 
        // 2 8 13 19 22 28 35 51
        int mod = 1000000007;
        Map<Integer,Integer> rightCnt = new HashMap<>();
        Map<Integer,Integer> leftCnt = new HashMap<>();
        long ret = 0;
        for(int num: nums){
            rightCnt.put(num, rightCnt.getOrDefault(num,0)+1);
        }

        for(int num:nums){
            int target = num*2;
            int lcount = leftCnt.getOrDefault(target,0);
            leftCnt.put(num, leftCnt.getOrDefault(num,0)+1);
            int rcount = rightCnt.getOrDefault(target,0)-leftCnt.getOrDefault(target,0);
            //System.out.println(lcount + " " + rcount);
            
            //rightCnt.remove(num);
            ret = (ret + (long)lcount*rcount)%mod;
        }
        return (int)ret;


    }
}