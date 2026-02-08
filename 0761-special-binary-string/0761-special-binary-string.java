class Solution {
    public String makeLargestSpecial(String s) {
        // 1 101100 0

        int start=0, cnt =0;
        List<String> subSpecials = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0')
                cnt++;
            else    
                cnt--;
            if(cnt==0){
                String sub = "1"+ makeLargestSpecial(s.substring(start+1, i))+"0";
                subSpecials.add(sub);
                start = i+1;
            }
        }
        subSpecials.sort((a,b)-> b.compareTo(a));
        return String.join("", subSpecials);

    }
}