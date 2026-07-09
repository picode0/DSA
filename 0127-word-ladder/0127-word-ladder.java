class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        int ret= 1;
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int k=0;k<size;k++){
                String poll = queue.poll(); 
                if(endWord.equals(poll))
                        return ret;
                for(int i=0;i<wordList.size();i++){
                    if(visited.contains(wordList.get(i)))
                        continue;
                    
                    int cnt = 0;
                    for(int j=0;j<wordList.get(i).length();j++){
                        if(poll.charAt(j) != wordList.get(i).charAt(j))
                                cnt++;
                    }
                    if(cnt==1){
                        queue.offer(wordList.get(i));
                        visited.add(wordList.get(i));
                        //System.out.println(wordList.get(i) + " " + i + " " + ret);
                    }
                }
            }
            ret++;
        }
        return 0;

    }
}