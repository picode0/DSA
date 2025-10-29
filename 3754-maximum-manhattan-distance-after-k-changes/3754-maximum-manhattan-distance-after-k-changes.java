class Solution {
    public int maxDistance(String s, int k) {
        int north = 0, south = 0, west = 0, east = 0;
        int ver = 0, hor = 0;
        int ret = 0;
        for(int i=0;i<s.length();i++){
            switch(s.charAt(i)){
                case 'N':
                    ver++;
                    break;
                case 'S':
                    ver--;
                    break;
                case 'W':
                    hor++;
                    break;
                case 'E':
                    hor--;
                    break;
            }
            /*
            int t1 = Math.min(Math.min(north, south), k);
            int t2 = Math.min(Math.min(west, east), k-t1);

            ret = Math.max(ret, dirC(north,south,t1) + dirC(west,east, t2));
            */
            ret = Math.max(ret, Math.min(Math.abs(ver)+Math.abs(hor)+2*k, i+1));
        }
        return ret; 
    }

    public int dirC(int dir1, int dir2, int times){
        return Math.abs(dir1-dir2) + 2*times;
    }
}