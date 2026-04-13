class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int step = 0;
        int sum = 0;

        while(sum<target){
            sum+= ++step;
        }

        while( (sum-target)%2 != 0){
            sum+= ++step;
        }
        return step;

    }
}