class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        // 1 3 4 9
        // 6 7 12 13

        // 1 3
        // 3 10 


        // 3 3 2

        int[] startTime = new int[flowers.length];
        int[] endTime = new int[flowers.length];

        for(int i=0;i<flowers.length;i++){
            startTime[i] = flowers[i][0];
            endTime[i] = flowers[i][1]+1;
        }

        Arrays.sort(startTime);
        Arrays.sort(endTime);

        int[] ret = new int[people.length];

        for(int i=0;i<people.length;i++){
            //System.out.println(binaryS(startTime, people[i]) + " " + binaryS(endTime, people[i]));
            ret[i] = binaryS(startTime,people[i]) - binaryS(endTime,people[i]);
        }
        return ret;
    }

    public int binaryS(int[] times, int target){
        int left=0, right=times.length;

        while(left<right){
            int mid = left + (right-left)/2;
            if(times[mid]>target)
                right = mid;
            else
                left = mid+1; 
        }
        return left;
    }
}