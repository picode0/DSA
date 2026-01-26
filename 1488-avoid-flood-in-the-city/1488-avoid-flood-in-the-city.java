class Solution {
    public int[] avoidFlood(int[] rains) {
        int[] ret = new int[rains.length];

        Map<Integer,Integer> idxMap = new HashMap<>();
        TreeSet<Integer> zeroes = new TreeSet<>();
        // 69 -> 0
        // 
        // 1 2 3  
        // -1, 69 
        for(int i=0;i<rains.length;i++){
            if(rains[i] == 0){
                zeroes.add(i);
                ret[i] = 1;
            }
            else{
                ret[i] = -1;
                if(idxMap.containsKey(rains[i])){
                    Integer nextZero = zeroes.ceiling(idxMap.get(rains[i]));
                    if(nextZero == null)
                        return new int[0];
                    ret[nextZero] = rains[i];
                    zeroes.remove(nextZero);
                }
                idxMap.put(rains[i],i);
            }
        }
        return ret; 
    }
}