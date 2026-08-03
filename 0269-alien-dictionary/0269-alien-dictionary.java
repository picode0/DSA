class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> adjList = new HashMap<>();
        int[] indegree = new int[26];

        //Arrays.fill(indegree, -1);
        for(String word: words){
            for(char c: word.toCharArray()){
                //indegree[c-'a'] = 0;
                adjList.putIfAbsent(c, new HashSet<>());
            }
        }


        for(int i=0;i<words.length-1;i++){
            String word1 = words[i], word2 = words[i+1];
            if(word1.startsWith(word2) && word1.length() > word2.length())
                return "";
            for(int j=0;j<Math.min(word1.length(), word2.length());j++){
                if(word1.charAt(j) != word2.charAt(j)){
                    if(!adjList.get(word1.charAt(j)).contains(word2.charAt(j))){
                        adjList.get(word1.charAt(j)).add(word2.charAt(j));
                        indegree[word2.charAt(j)-'a']++;
                    }
                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();

        for(Character c: adjList.keySet()){
            if(indegree[c-'a'] == 0)
                queue.offer(c);
        }

        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            char c = queue.poll();
            sb.append(c);
            for(char ch : adjList.get(c)){
                if(--indegree[ch-'a'] ==0)
                    queue.offer(ch);
            }
        }

        return sb.length() == adjList.size() ? sb.toString():"";


    }
}