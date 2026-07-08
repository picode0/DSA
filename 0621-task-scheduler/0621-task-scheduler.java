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

        int time = 0;
        while(!taskfreq.isEmpty()){
            int cycle = n +1;
            List<Integer> tempStore = new ArrayList<>();
            int taskCnt = 0;
            while(cycle>0 && !taskfreq.isEmpty()){
                int freq = taskfreq.poll();
                if(freq>1)
                    tempStore.add(freq-1);
                taskCnt++;
                cycle--;
            }
            for(int storeFreq: tempStore)
                taskfreq.offer(storeFreq);
            time += taskfreq.isEmpty()?taskCnt:n+1;
        }
        return time;
        /*
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
        */
    }
}