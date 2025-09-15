class Solution {
    public int maximumSwap(int num) {
        char[] toArr = Integer.toString(num).toCharArray();
        int maxdigit = -1, maxpos = -1, sidx1 = -1, sidx2 = -1;
        int n = toArr.length;

        for(int i=n-1;i>=0;i--){
            if(toArr[i] > maxdigit){
                maxdigit = toArr[i]; 
                maxpos = i;
            }
            else if(toArr[i] < maxdigit){
                sidx1 = i;
                sidx2 = maxpos;
                //System.out.println(sidx1 + " " + sidx2);
            }
        }

        if(sidx1!=-1 && sidx2!=-1){
            char temp = toArr[sidx1];
            toArr[sidx1] = toArr[sidx2];
            toArr[sidx2] = temp;
        }

        return Integer.parseInt(new String(toArr));

    }
}