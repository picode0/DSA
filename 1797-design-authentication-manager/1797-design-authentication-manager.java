class AuthenticationManager {

    class SIPair{
        String id;
        int time;
        SIPair(String id, int time){
            this.id = id;
            this.time = time;
        }
    }

    int expireTime;
    Map<String, Integer> mapEnd;
    PriorityQueue<SIPair> pq;
    public AuthenticationManager(int timeToLive) {
        expireTime = timeToLive;
        mapEnd = new HashMap<>();
        pq = new PriorityQueue<>((a,b)->a.time - b.time);
    }
    
    public void generate(String tokenId, int currentTime) {
        if(!mapEnd.containsKey(tokenId))
            pq.offer(new SIPair(tokenId, currentTime+expireTime));
        mapEnd.put(tokenId, currentTime + expireTime);
    }
    
    public void renew(String tokenId, int currentTime) {
        if(mapEnd.containsKey(tokenId) && mapEnd.get(tokenId)>currentTime)
            mapEnd.put(tokenId, currentTime+expireTime);
    }
    
    public int countUnexpiredTokens(int currentTime) {
        //int ret = 0;
        while(!pq.isEmpty() && pq.peek().time <= currentTime){
            SIPair poll = pq.poll();
            if(mapEnd.get(poll.id) > currentTime)
                pq.offer(new SIPair(poll.id, mapEnd.get(poll.id)));
        }
        return pq.size();
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */