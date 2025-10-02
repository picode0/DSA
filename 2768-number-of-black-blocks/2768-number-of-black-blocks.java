class Solution {
    public long[] countBlackBlocks(int m, int n, int[][] coordinates) {
        int[][] dir = {{-1,-1},{0, -1},{-1,0}};
        Map<String, Integer> map = new HashMap<>();
        for(int[] coordinate:coordinates){
            String curr = coordinate[0]+ "*" + coordinate[1];
            if(coordinate[0]!=m-1 && coordinate[1]!=n-1)
                map.put(curr, map.getOrDefault(curr, 0)+1);

            for(int i=0;i<3;i++){
                int newr = coordinate[0] + dir[i][0];
                int newc = coordinate[1] + dir[i][1];
                if(newr>=0 && newr<m-1 && newc>=0 && newc<n-1)
                    map.put(newr+"*"+newc, map.getOrDefault(newr+"*"+newc, 0)+1);
            }
        }
        long[] ret = new long[5];
        ret[0] = (long)(m-1)*(n-1) - map.size();

        for(int value: map.values()){
            ret[value]++;
        }
        return ret;

        /*
        Set<String> pairs = new HashSet<>();
        long[] ret = new long[5];
        for(int[] coordinate: coordinates)
            pairs.add(coordinate[0] + "*" + coordinate[1]);

        for(int i=0;i<m-1;i++){
            for(int j=0;j<n-1;j++){
                int curr = pairs.contains(i+"*"+j)?1:0;
                int right = pairs.contains(i+"*"+(j+1))?1:0;
                int down = pairs.contains((i+1)+"*"+j)?1:0;
                int diag = pairs.contains((i+1)+"*"+(j+1))?1:0;
                ret[curr+right+down+diag]++;
            }
        }
        return ret;
        */
    }
}