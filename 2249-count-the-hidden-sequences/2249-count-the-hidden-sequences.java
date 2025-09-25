class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        // 0 1 -2 2 
        // 1 2 -1 3 
        // 3 4 1 5 
        // 4 5 2 6 
        int max =0, min = 0;

        int curr = 0;

        for(int diff: differences){
            curr+=diff; 
            max = Math.max(max, curr);
            min = Math.min(min, curr);
            if(max-min > upper-lower)
                return 0;
        }

        return upper-lower+1 - (max-min);

    }
}