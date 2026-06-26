class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] charCnt = new int[26];
        for(char task:tasks)
            charCnt[task-'A']++;

        PriorityQueue<Integer> taskfreq = new PriorityQueue<>((a,b)->b-a);

        for(int i=0;i<26;i++){
            if(charCnt[i]>0)
                taskfreq.offer(charCnt[i]);
        }

        Queue<int[]> endtime = new LinkedList<>();
        int time = 0;
        while(!taskfreq.isEmpty() || !endtime.isEmpty()){
            time++;
            if(!taskfreq.isEmpty()){
                int freq = taskfreq.poll()-1;
                if(freq >0){
                    endtime.offer(new int[]{freq, time+n});
                }
            }

            if(!endtime.isEmpty() && endtime.peek()[1] == time){
                taskfreq.offer(endtime.poll()[0]);
            }
        }
        return time;
    }
}