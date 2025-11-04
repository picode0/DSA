class TaskManager {
    Map<Integer, int[]> taskMap;
    PriorityQueue<int[]> pq;
    public TaskManager(List<List<Integer>> tasks) {
        taskMap = new HashMap<>();
        pq = new PriorityQueue<>((a,b)->(a[1]==b[1]?b[0]-a[0]:b[1]-a[1]));

        for(List<Integer> task: tasks){
            int userId = task.get(0);
            int taskId = task.get(1);
            int priority = task.get(2);

            taskMap.put(taskId, new int[]{userId, priority});
            pq.add(new int[]{taskId, priority});
        }

    }
    
    public void add(int userId, int taskId, int priority) {
        taskMap.put(taskId, new int[]{userId, priority});
        pq.add(new int[]{taskId, priority});
    }
    
    public void edit(int taskId, int newPriority) {
        taskMap.get(taskId)[1] = newPriority;
        pq.add(new int[]{taskId, newPriority});

    }
    
    public void rmv(int taskId) {
        taskMap.remove(taskId);
    }
    
    public int execTop() {
        while(!pq.isEmpty()){
            int[] poll = pq.poll();
            int tId = poll[0];
            int p = poll[1];
            if(taskMap.containsKey(tId) && taskMap.get(tId)[1] == p){
                int uId = taskMap.get(tId)[0];
                taskMap.remove(tId);
                return uId;
            }
        }
        return -1;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */