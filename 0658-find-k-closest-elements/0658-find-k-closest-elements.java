class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        int left = 0, right = arr.length-k;

        while(left<right){
            int mid = left + (right-left)/2;

            if(x- arr[mid] > arr[mid+k]-x){
                left = mid +1;
            }
            else 
               right = mid;
            // 2 4 7
        }

        List<Integer> ret = new ArrayList<>();
        for(int i=left;i<left+k;i++)
            ret.add(arr[i]);

        return ret; 

    }
}