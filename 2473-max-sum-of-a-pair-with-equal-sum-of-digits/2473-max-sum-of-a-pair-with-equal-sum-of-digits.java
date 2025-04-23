class Solution {
    public int maximumSum(int[] nums) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int num:nums){
            int val = 0;
            int temp = num;
            while(temp>0){
                val+=(temp%10);
                temp/=10;
            }
            //System.out.println(val);
            List<Integer> list = map.getOrDefault(val, new ArrayList<>());
            list.add(num);
            map.put(val, list);
        }
        int ret = -1;
        for(Map.Entry<Integer,List<Integer>> entry : map.entrySet()){
            List<Integer> list = entry.getValue();
            if(list.size()>=2){
                Collections.sort(list);
                ret = Math.max(ret, list.get(list.size()-1) + list.get(list.size()-2));
            }
        }

        return ret;
    }
}