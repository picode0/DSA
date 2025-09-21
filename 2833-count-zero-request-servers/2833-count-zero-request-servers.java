class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {

        int[] ret = new int[queries.length];
        Arrays.sort(logs, (a,b) -> a[1] - b[1]);

        List<int[]> sortedQueries = new ArrayList<>();
        for(int i=0;i<queries.length;i++){
            sortedQueries.add(new int[]{queries[i], i});
        }
        Collections.sort(sortedQueries, (a,b)->a[0]-b[0]);

        // (2,1) (3,1) (1,2) (2,4) 
        // ((3,0) (4,1))
        int left = 0, right = 0;
        Map<Integer,Integer> map = new HashMap<>();

        for(int[] query: sortedQueries){
            int start = query[0] - x;
            int end = query[0];
            int id = query[1];

            while(right < logs.length && logs[right][1] <= end){
                map.put(logs[right][0], map.getOrDefault(logs[right][0], 0) +1 );
                right++;
            }

            while(left< logs.length && logs[left][1] < start){
                map.put(logs[left][0], map.getOrDefault(logs[left][0], 0) -1);
                if(map.get(logs[left][0]) <= 0)
                    map.remove(logs[left][0]);
                left++;
            }
            ret[id] = n - map.size();

        }
        return ret;
    }
}