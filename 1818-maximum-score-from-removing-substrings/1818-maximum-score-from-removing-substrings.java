class Solution {
    public int maximumGain(String s, int x, int y) {
        int ret = 0 ;
        Stack<Character> stack = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        char first;
        char second;
        if(x>y){
            first = 'a';
            second = 'b';
        }
        else{
            first = 'b';
            second = 'a';
        }

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)== second && !stack.isEmpty() && stack.peek()==first){
                stack.pop();
                ret+= x>y?x:y;
            }
            else
                stack.push(s.charAt(i));
        }
  
        while(!stack.isEmpty()){
            char c = stack.pop();
            if(c==second && !stack2.isEmpty() && stack2.peek()==first){
                stack2.pop();
                ret+= x>y?y:x;
            }
            else
                stack2.push(c);
        }

        return ret;
    }
}