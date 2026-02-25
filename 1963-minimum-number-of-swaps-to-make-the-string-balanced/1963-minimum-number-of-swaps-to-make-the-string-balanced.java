class Solution {
    public int minSwaps(String s) {
        Stack<Character> stack = new Stack<>();
        int numClosing = 0;
        for(Character c: s.toCharArray()){
            if(c=='[')
                stack.push(c);
            else{
                if(!stack.isEmpty())
                    stack.pop();
                else
                    numClosing++;
            }
        }
        return (numClosing+1) /2;
    }
}