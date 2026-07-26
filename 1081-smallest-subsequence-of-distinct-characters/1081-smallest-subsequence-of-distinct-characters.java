class Solution {
    public String smallestSubsequence(String s) {
        int[] charcnt = new int[26];
        for(char c: s.toCharArray()){
           charcnt[c-'a']++;
        }

        Stack<Character> stack = new Stack<>();
        boolean[] visited = new boolean[26];
        for(char c: s.toCharArray()){
            charcnt[c-'a']--;

            if(visited[c-'a'])
                continue;
            
            while(!stack.isEmpty() && stack.peek()>c && charcnt[stack.peek()-'a']>0){
                visited[stack.pop()-'a'] = false;
            }
            stack.push(c);
            visited[c-'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0, stack.pop());
        }
        return sb.toString();
        
    }
}