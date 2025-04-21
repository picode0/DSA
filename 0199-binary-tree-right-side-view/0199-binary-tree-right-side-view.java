/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {

        
        List<Integer> ret = new ArrayList<>();

        if(root==null)
            return ret;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i=0;i<size;i++){
                TreeNode pop = queue.poll();
                if(i==size-1)
                    ret.add(pop.val);
                if(pop.left!=null)
                    queue.offer(pop.left);
                if(pop.right!=null)
                    queue.offer(pop.right);
            }

        }
        return ret;
    }
}