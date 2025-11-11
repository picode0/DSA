class Solution {
    public String[] findRelativeRanks(int[] score) {
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
    }
}