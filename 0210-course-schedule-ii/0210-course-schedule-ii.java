class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++)
            graph.add(new ArrayList<>());

        for(int[] prerequisite : prerequisites){
            graph.get(prerequisite[1]).add(prerequisite[0]);
            indegree[prerequisite[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0)
                queue.add(i);
        }
        int[] ret = new int[numCourses];
        
        int idx = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int poll = queue.poll();
                ret[idx++] = poll;
                List<Integer> list = graph.get(poll);
                for(int num: list){
                    if(--indegree[num] == 0)
                        queue.add(num);
                }
            }
        }

    if(idx == numCourses)
        return ret;
    else    
        return new int[0];

        /*
        1 -> 0
        2 -> 0
        3 -> 1,2

        0->1,2
        1->3
        2->3
        */
    }
}