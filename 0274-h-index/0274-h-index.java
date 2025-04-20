class Solution {
    public int hIndex(int[] citations) {
        // 0 1 3  5 6
        // 1,6  2,5  3,4  4,4

        // 1 1 0 1 2
        
        // 6 5 4 4 1 0  
        // 0 1 3 4 5 6 
        //
        // 3, 1, 1
        //1 1 3
        // 1, 3   2, 1
    

        Arrays.sort(citations);

        for(int i=0;i<citations.length;i++){
            if(i >= citations[citations.length-1-i])
                return i;
        }

        return citations.length;
    }
}