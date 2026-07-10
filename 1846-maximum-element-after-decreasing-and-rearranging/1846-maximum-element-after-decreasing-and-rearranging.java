class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int ret = 1;
        for(int i=1;i<arr.length;i++){
            if(arr[i] >= ret+1)
                ret++;
        }
        return ret;
    }
}