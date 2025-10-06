class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int ret = 0;
        Set<String> set = new HashSet<>();
        for(int num: arr1){
            String numToString = num+"";
            StringBuilder sb = new StringBuilder();
            for(char c: numToString.toCharArray()){
                sb.append(c);
                set.add(sb.toString());
            }
        }
        for(int num2: arr2){
            StringBuilder sb2 = new StringBuilder();
            String num2ToString = num2 + "";
            for(char c: num2ToString.toCharArray()){
                sb2.append(c); 
                if(set.contains(sb2.toString())){
                    ret = Math.max(ret, sb2.length());
                }
            }
        }
        
        return ret;
    }
}