class Solution {
    public int calculate(String s) {
        // 3 - 2*2 = 1

        int lastNum = 0, currNum = 0, ret = 0;
        char operation = '+';
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                currNum = (currNum*10) + (c-'0');
            }
            if(!Character.isDigit(c) && !Character.isWhitespace(c) || i == s.length()-1){
                if(operation == '+' || operation == '-'){
                    ret+=lastNum;
                    lastNum = operation=='+'?currNum:-currNum;
                }
                if(operation == '*')
                    lastNum = lastNum * currNum;
                if(operation == '/')
                    lastNum = lastNum / currNum;
                
                currNum = 0;
                operation = c;
            }
        }

        ret+=lastNum;
        return ret; 

    }
}