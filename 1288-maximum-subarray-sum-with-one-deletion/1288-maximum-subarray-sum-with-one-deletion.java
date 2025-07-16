class Solution {
    public int maximumSum(int[] arr) {
        // 1 -1 0 3
        // 2  1 3 3

        //1 -1  -2  3
        //1  -1  1  3 

        //-1 -1  -1  -1
        //-1 -1  -1  -1
        int ret = arr[0];
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0]; 
        for(int i=1;i<arr.length;i++){
            prefix[i] = Math.max(arr[i], arr[i]+prefix[i-1]);
            ret = Math.max(ret, prefix[i]);
            //System.out.println("prefix " + prefix[i]);
        }

        int[] suffix = new int[arr.length];
        suffix[suffix.length-1] = arr[arr.length-1];
        for(int i=arr.length-2;i>=0;i--){
            suffix[i] = Math.max(arr[i], arr[i]+suffix[i+1]);
            ret = Math.max(ret, suffix[i]);
            //System.out.println("suffix " + suffix[i]);
        }

        for(int i=1;i<arr.length-1;i++){
            ret = Math.max(ret, prefix[i-1] + suffix[i+1]);
        }

        return ret;
    }
}