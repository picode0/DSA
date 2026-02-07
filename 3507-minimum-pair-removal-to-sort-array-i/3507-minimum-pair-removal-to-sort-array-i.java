class Solution {
    int minSum;
    int idx;
    public int minimumPairRemoval(int[] nums) {
        
        List<Integer> list = new ArrayList<>();
        for(int num:nums)
            list.add(num);
        //minSum = Integer.MAX_VALUE;
        //idx = -1;
        int ret = 0;
        while(!isNonDecreasing(list)){
            list.set(idx-1, list.get(idx) + list.get(idx-1));
            list.remove(idx);
            ret++;
        }
        return ret;
    }

    public boolean isNonDecreasing(List<Integer> list){
        minSum = Integer.MAX_VALUE;
        idx = -1;
        boolean ret = true;
        for(int i=1;i<list.size();i++){
            if(list.get(i-1) > list.get(i))
                ret = false;

            if(list.get(i-1)+list.get(i)<minSum){
                minSum = list.get(i) + list.get(i-1);
                idx = i;
            }
            
        }
        return ret;
    }
}