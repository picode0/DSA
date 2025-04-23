class Solution {
    public int maximumSum(int[] nums) {

        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for(int num:nums){
            int val = 0;
            int temp = num;
            while(temp>0){
                val+=(temp%10);
                temp/=10;
            }
            //System.out.println(val);
            PriorityQueue<Integer> list = map.getOrDefault(val, new PriorityQueue<>( (a,b)-> b-a ));
            list.add(num);
            map.put(val, list);
        }
        int ret = -1;
        for(Map.Entry<Integer,PriorityQueue<Integer>> entry : map.entrySet()){
            PriorityQueue<Integer> list = entry.getValue();
            if(list.size()>=2){
                ret = Math.max(ret, list.poll() + list.poll());
            }
        }

        return ret;
    }
}