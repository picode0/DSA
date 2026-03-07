class Solution {
    public int minPartitions(String n) {
        
        int ret = 0;
        for(char c: n.toCharArray()){
            ret = Math.max(ret, c-'0');
        }
        
        return ret; 
    }
}