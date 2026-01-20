class Solution {
    public int bestClosingTime(String customers) {

        int n = customers.length();
        int[] prefixN = new int[n+1];
        int[] prefixY = new int[n+1];

        // 0 1 2 2 3
        // 0 0 0 1 1
        /*
        if(customers.charAt(0)=='N')
            prefixN[0] = 1;
        else
            prefixY[0] = 1;
        */

        for(int i=1;i<=n;i++){
            if(customers.charAt(i-1)=='Y')
                prefixY[i]++;
            else
                prefixN[i]++;
            
            prefixY[i]+=prefixY[i-1];
            prefixN[i]+=prefixN[i-1];
        }

        int minHour = 0;
        int minPenalty = n;
        for(int i=0;i<=n;i++){
            int currPenalty = prefixY[n]-prefixY[i] + prefixN[i];
            if(minPenalty > currPenalty){
                minPenalty = currPenalty;
                minHour = i;
                //System.out.println("penalty " + currPenalty + " i " + i);
            }
        }
        return minHour;


    }
}