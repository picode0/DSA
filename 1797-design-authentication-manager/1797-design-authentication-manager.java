class AuthenticationManager {
    int expireTime;
    Map<String, Integer> mapEnd;
    public AuthenticationManager(int timeToLive) {
        expireTime = timeToLive;
        mapEnd = new HashMap<>();
    }
    
    public void generate(String tokenId, int currentTime) {
        mapEnd.put(tokenId, currentTime + expireTime);
    }
    
    public void renew(String tokenId, int currentTime) {
        if(mapEnd.containsKey(tokenId) && mapEnd.get(tokenId)>currentTime)
            mapEnd.put(tokenId, currentTime+expireTime);
    }
    
    public int countUnexpiredTokens(int currentTime) {
        int ret = 0;
        for(int endTime : mapEnd.values()){
            if(endTime > currentTime)
                ret++;
        }
        return ret;
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */