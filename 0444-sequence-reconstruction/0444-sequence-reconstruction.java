class Solution {
    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {
        // (1 2) (1 3)
        // 1-> 2,3 

        // 5->2,2
        // 2->6
        // 6->3
        // 4->1
        // 1->5
        

        // 4, 1, 5, 2 
        int n = nums.length;
        int[] indegree = new int[n+1];
        List<List<Integer>> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<=n;i++)
            list.add(new ArrayList<>());

        for(List<Integer> sequence: sequences){
            for(int i=1;i<sequence.size();i++){
                int prev = sequence.get(i-1);
                int next = sequence.get(i);
                list.get(prev).add(next);
                indegree[next]++;
            }
        }

        for(int i=1;i<=n;i++){
            if(indegree[i]==0)
                queue.offer(i);
        }

        int idx = 0; 

        while(!queue.isEmpty()){
            if(queue.size()>1 || queue.peek()!=nums[idx])
                return false;
            
            int poll = queue.poll();
            for(int node: list.get(poll)){
                if(--indegree[node]==0)
                    queue.offer(node);
            }
            idx++;
        }
        return true;

    }
}