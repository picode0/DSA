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
        
        Map<Integer, Employee> map = new HashMap<>();
        

        for(Employee emp: employees){
            map.put(emp.id, emp);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(id);

        int ret = 0;
        while(!queue.isEmpty()){
            int poll = queue.poll();
            ret += map.get(poll).importance;
            for(int sub: map.get(poll).subordinates){
                queue.offer(sub);
            }
        }
        return ret;
        

    }
}