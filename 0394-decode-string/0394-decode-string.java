class Solution {
    public String decodeString(String s) {
        Stack<String> stStack = new Stack<>();
        Stack<Integer> cntStack = new Stack<>();
        StringBuilder currSb = new StringBuilder();
        int k =0;

        for(char c: s.toCharArray()){
            if(Character.isDigit(c)){
                k = k*10 + c-'0';
            }
            else if(c == '['){
                cntStack.push(k);
                stStack.push(currSb.toString());
                currSb = new StringBuilder();
                k=0;
            }
            else if(c==']'){
                StringBuilder decode = new StringBuilder(stStack.pop());
                int cnt = cntStack.pop();
                for(int i=0;i<cnt;i++){
                    decode.append(currSb.toString());
                }
                currSb = decode;
            }
            else
                currSb.append(c);
            
            //System.out.println(currSb.toString());
        }

        return currSb.toString();

    }
}