class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer,Integer> map = new HashMap<>();
        int cnt=0, ret=0, left=0;
        for(int i : fruits){
            map.put(i, map.getOrDefault(i,0)+1);
            while(map.size()>2){
                map.put(fruits[left], map.get(fruits[left])-1);
                if(map.get(fruits[left])==0)
                    map.remove(fruits[left]);
                left++;
                cnt--;
            }
            cnt++;
            ret = Math.max(ret, cnt);
        }
        return ret;
    }
}