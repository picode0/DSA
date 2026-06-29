/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, List<TreeNode>> neighbors = new HashMap<>();
        neighbors.put(root, new ArrayList<>());
        dfs(root, neighbors);

        Queue<TreeNode[]> bfsqueue = new LinkedList<>();

        bfsqueue.offer(new TreeNode[]{target, null});

        int count=0;
        List<Integer> ret = new ArrayList<>();
        while(!bfsqueue.isEmpty()){
            if(count++ == k){
                while(!bfsqueue.isEmpty()){
                    ret.add(bfsqueue.poll()[0].val);
                }
                return ret;
            }
            int size = bfsqueue.size();
            for(int i=0;i<size;i++){
                TreeNode[] curr = bfsqueue.poll();
                for(TreeNode neighbor: neighbors.get(curr[0])){
                    //System.out.println(neighbor.val + " val " + curr[0].val);
                    if(neighbor!=curr[1]){
                        bfsqueue.offer(new TreeNode[]{neighbor, curr[0]});
                    }
                }
            }
        }

        return ret;
        
    }
    public void dfs(TreeNode root, Map<TreeNode,List<TreeNode>> neighbors){
        if(root==null)
            return;

        //neighbors.put(root, new ArrayList<>());
        if(root.left!=null){
            neighbors.putIfAbsent(root.left, new ArrayList<>());
            neighbors.get(root.left).add(root);
            neighbors.get(root).add(root.left);
        }
        if(root.right!=null){
            neighbors.putIfAbsent(root.right, new ArrayList<>());
            neighbors.get(root.right).add(root);
            neighbors.get(root).add(root.right);
        }

        dfs(root.left, neighbors);
        dfs(root.right, neighbors);

    }
}