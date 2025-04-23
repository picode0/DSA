class Solution {
    public String removeOccurrences(String s, String part) {
        Stack<Character> st = new Stack<>();
        for(Character c: s.toCharArray()){
            st.push(c);
            if(st.size() >= part.length() && isMatch(s, part, st)){
                for(int i=0;i<part.length();i++){
                    st.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty())
            sb.insert(0, st.pop());
        
        return sb.toString();

    }
    public boolean isMatch(String s, String part, Stack<Character> st){
        Stack<Character> tempst = new Stack<>();
        tempst.addAll(st);
        for(int i=part.length()-1;i>=0;i--){
            if(part.charAt(i) != tempst.pop())
                return false;
        }
        return true;
    }

}