class Solution {
    public boolean checkValidString(String s) {
        int lowerBound = 0, upperBound = 0; 

        for(char c: s.toCharArray()){
            if(c=='('){
                lowerBound++;
                upperBound++;
            }
            else if(c==')'){
                if(lowerBound >0)
                    lowerBound--;
                upperBound--;
            }
            else{
                if(lowerBound>0)
                    lowerBound--;
                upperBound++;
            }

            if(upperBound <0)
                return false;

        }

        return lowerBound==0;
    }
}