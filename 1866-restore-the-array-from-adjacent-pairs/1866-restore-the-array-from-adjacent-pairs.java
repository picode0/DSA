class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    public int[] restoreArray(int[][] adjacentPairs) {
        // 2-> 1, 3
        // 1->2
        //3->4,2
        // 4-> 3
        
        for(int[] pair: adjacentPairs){
            List<Integer> list = map.getOrDefault(pair[0], new ArrayList<>());
            List<Integer> list2 = map.getOrDefault(pair[1], new ArrayList<>());
            list.add(pair[1]);
            list2.add(pair[0]);
            map.put(pair[0], list);
            map.put(pair[1], list2);
        }
        int first = 0;
        for(int n: map.keySet()){
            if(map.get(n).size()==1){
                first = n;
                break;
            }
        }

        int[] ret = new int[adjacentPairs.length+1];
        dfs(ret, first, -1, 0);
        return ret; 


    }

    public void dfs(int[] ret, int curr, int prev, int i){
        if(i==ret.length)
            return;

        ret[i] = curr;
        for(int next: map.get(curr)){
            if(next!=prev)
                dfs(ret, next, curr, i+1);
        }

    }
}