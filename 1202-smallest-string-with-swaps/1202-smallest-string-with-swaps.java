class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        UF uf = new UF(s.length());

        for(List<Integer> pair: pairs){
            uf.union(pair.get(0), pair.get(1));
        }

        Map<Integer, PriorityQueue<Character>> charMap = new HashMap<>();

        for(int i=0;i<s.length();i++){
            int head = uf.find(i);
            PriorityQueue<Character> pq = charMap.getOrDefault(head, new PriorityQueue<>());
            pq.offer(s.charAt(i));
            charMap.put(head, pq);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            sb.append(charMap.get(uf.find(i)).poll());
        }
        return sb.toString();

    }

    class UF{
        int[] size;
        int[] head;
        UF(int length){
            size = new int[length];
            head = new int[length];

            for(int i=0;i<length;i++){
                size[i] = 1;
                head[i] = i;
            }
        }

        public int find(int a){
            if(head[a]==a)
                return a;
            head[a] = find(head[a]);
            return head[a];
        }

        public void union(int a, int b){
            int ahead = find(a);
            int bhead = find(b);

            if(ahead!=bhead){
                if(size[ahead] > size[bhead]){
                    head[bhead] = ahead;
                    size[ahead]+=size[bhead];
                }
                else{
                    head[ahead] = bhead;
                    size[bhead]+=size[ahead];
                }
            }
        }


    }
}