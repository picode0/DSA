/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] imp = new int[2001];
        Arrays.fill(imp, 101);

        for(Employee emp: employees){
            imp[emp.id] = emp.importance;
            map.putIfAbsent(emp.id, new ArrayList<>());
            for(int sub: emp.subordinates)
                map.get(emp.id).add(sub);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(id);

        int ret = 0;
        while(!queue.isEmpty()){
            int poll = queue.poll();
            ret += imp[poll];
            for(int sub: map.get(poll)){
                queue.offer(sub);
            }
        }
        return ret;

    }
}