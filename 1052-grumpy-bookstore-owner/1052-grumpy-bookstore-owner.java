class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int satisfied = 0;
        int max = 0;
        for(int i=0;i<customers.length;i++){
            if(grumpy[i]==0)
                satisfied+=customers[i];
        }

        int left = 0;
        for(int right =0;right<customers.length;right++){
            if(grumpy[right] == 1)
                satisfied+=customers[right];
            
            if(right>=minutes){
                if(grumpy[left++]==1)
                    satisfied-=customers[left-1];
            }
            max = Math.max(satisfied, max);
        }
        return max;
    }
}