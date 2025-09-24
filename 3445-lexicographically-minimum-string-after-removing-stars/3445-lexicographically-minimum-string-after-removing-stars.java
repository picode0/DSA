class Solution {
    public String clearStars(String s) {
        Map<Character, List<Integer>> map = new HashMap<>(); 
        StringBuilder sb = new StringBuilder(); 
        PriorityQueue<Character> pq = new PriorityQueue<>(); 
        Set<Integer> set = new HashSet<>(); 

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i); 
            if(c=='*'){
                char smallest = pq.poll(); 
                int size = map.get(smallest).size();
                int idx = map.get(smallest).get(size-1);
                map.get(smallest).remove(size-1); 
                set.add(i);
                set.add(idx);
            }
            else{
                pq.offer(c); 
                List<Integer> list = map.getOrDefault(c, new ArrayList<>());
                list.add(i);
                map.put(c, list); 
            }
        }

        for(int i=0;i<s.length();i++){
            if(!set.contains(i))
                sb.append(s.charAt(i));
        }

        return sb.toString();


    }
}