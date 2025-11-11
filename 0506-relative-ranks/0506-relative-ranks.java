class Solution {
    public String[] findRelativeRanks(int[] score) {

        int max = 0;
        for(int sc: score)
            max = Math.max(max, sc);

        int[] idx = new int[max+1];
        Arrays.fill(idx, -1);
        for(int i=0;i<score.length;i++){
            idx[score[i]] = i;
        }

        String[] ret = new String[score.length];
        String[] medals = new String[]{"Gold Medal", "Silver Medal", "Bronze Medal"};
        int midx = 0;

        for(int i=idx.length-1;i>=0;i--){
            if(idx[i]!=-1){
                if(midx<3){
                    ret[idx[i]] = medals[midx];
                }
                else{
                    ret[idx[i]] = String.valueOf(midx+1);
                }
                midx++;
            }
        }
        return ret;

        /*
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[0]-a[0]);

        for(int i=0;i<score.length;i++)
            pq.add(new int[]{score[i],i});

        String[] ret = new String[score.length];
      
        for(int i=0;i<score.length;i++){
            int[] pair = pq.poll();
            if(i==0)
                ret[pair[1]] = "Gold Medal";
            else if(i==1)
                ret[pair[1]] = "Silver Medal";
            else if(i==2)
                ret[pair[1]] = "Bronze Medal";
            else
                ret[pair[1]] = String.valueOf(i+1);
        }
        return ret;
        */
    }
}