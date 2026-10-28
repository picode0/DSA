class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        int[] ret = new int[n];
        int[] increasing = new int[n];
        int incLen = 0;
        for(int i=0;i<n;i++){
            int height = obstacles[i];
            int insertIdx = binarySearch(increasing, incLen, height);
            if(incLen == insertIdx)
                incLen++;
            ret[i] = insertIdx + 1;
            increasing[insertIdx] = height;
        }
        return ret;

    }

    public int binarySearch(int[] increasing, int right, int target){
        // 1 2 3 
        int left = 0;
        while(left<right){
            int mid = left + (right-left)/2;
            if(increasing[mid]<=target){
                left = mid +1;
            }
            else{
                right = mid;
            }
        }
        return left;
    }
}