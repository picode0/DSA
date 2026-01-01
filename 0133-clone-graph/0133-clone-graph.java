/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node,Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node==null)
            return null;
        map.put(node, new Node(node.val));

        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        while(!queue.isEmpty()){
            Node poll = queue.poll();
            for(Node neighbor: poll.neighbors){
                if(!map.containsKey(neighbor)){
                    map.put(neighbor, new Node(neighbor.val));
                    queue.offer(neighbor);
                }
                map.get(poll).neighbors.add(map.get(neighbor));
            }

        }
        //dfs(node);
        return map.get(node);
        
    }
    /*
    public void dfs(Node node){
        for(Node neighbor : node.neighbors){
            if(!map.containsKey(neighbor)){
                map.put(neighbor, new Node(neighbor.val));
                dfs(neighbor);
            }
            map.get(node).neighbors.add(map.get(neighbor));
        }
    }
    */
}