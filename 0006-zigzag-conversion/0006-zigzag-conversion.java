class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1)
            return s;
        String[] str = new String[numRows];
        int multiplier = 1, idx = 0;
        for(char c : s.toCharArray()){
            if(str[idx]==null)
                str[idx]="";
            str[idx]+=c;
            idx+= multiplier;
            if(idx==numRows-1 || idx==0)
                multiplier*=-1;
        }
        StringBuilder sb = new StringBuilder();
        for(String row: str){
            if(row!=null)
                sb.append(row);
        }
            
        return sb.toString();

    }
}