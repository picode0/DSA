class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int start =0, end = people.length-1;

        int ret = 0;

        while(start<end){
            if(people[end] < limit && people[end]+people[start]<=limit){
                start++;
            }
            end--;
            ret++;
        }
        if(start==end)
            ret++;
            
        return ret; 
    }
}