class Solution {
    public int smallestRepunitDivByK(int k) {
        int val = 0;
        
        for(int i=1;i<=k;i++){
            val = (val*10 +1)%k;
            if(val ==0)
                return i;
        }
        return -1;
        /*
        int val = 1; 
        int length = 1;
        //int n = 0;

        Set<Integer> set = new HashSet<>();
        while(val%k !=0){
            val = (val*10 + 1)%k;
            length++;

            if(set.contains(val))
                return -1;
            set.add(val);
        }

        return length;
        */
    }
}