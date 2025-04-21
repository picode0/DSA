class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Set<String> banklist = new HashSet<>();

        char[] charset = new char[]{'A','C', 'G', 'T'};
        for(String st : bank)
            banklist.add(st);

        queue.offer(startGene);
        visited.add(startGene);

        int ret = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                String poll = queue.poll();
                if(poll.equals(endGene))
                    return ret;
                for(int j=0;j<4;j++){
                    for(int k=0;k<poll.length();k++){
                        String newSt = poll.substring(0, k) + charset[j] + poll.substring(k+1);
                        if(!visited.contains(newSt) && banklist.contains(newSt)){
                            visited.add(newSt);
                            queue.offer(newSt); 
                        }
                    }
                }
            }
            ret++;
        }

        return -1;

        
    }

}