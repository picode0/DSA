class Solution {
    public int maxDistance(String s, int k) {
        int north = 0, south = 0, west = 0, east = 0;
        int ret = 0;
        for(char c: s.toCharArray()){
            switch(c){
                case 'N':
                    north++;
                    break;
                case 'S':
                    south++;
                    break;
                case 'W':
                    west++;
                    break;
                case 'E':
                    east++;
                    break;
            }
            int t1 = Math.min(Math.min(north, south), k);
            int t2 = Math.min(Math.min(west, east), k-t1);

            ret = Math.max(ret, dirC(north,south,t1) + dirC(west,east, t2));
        }
        return ret; 
    }

    public int dirC(int dir1, int dir2, int times){
        return Math.abs(dir1-dir2) + 2*times;
    }
}