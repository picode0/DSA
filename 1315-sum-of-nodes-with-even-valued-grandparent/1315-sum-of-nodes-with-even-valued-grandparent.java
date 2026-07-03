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
    Map<TreeNode, TreeNode> parent;
    public int sumEvenGrandparent(TreeNode root) {
        parent = new HashMap<>();
        parent.put(root, null);

        return dfs(root);
    }

    public int dfs(TreeNode root){
        if(root==null)
            return 0; 

        if(root.left!=null)
            parent.put(root.left, root);
        if(root.right!=null)
            parent.put(root.right, root);

        int left = dfs(root.left);
        int right = dfs(root.right);

        int val = 0; 

        if(parent.get(root)!=null && parent.get(parent.get(root))!=null){
            if(parent.get(parent.get(root)).val %2 ==0){
                val = root.val;
            }
        }
        return val+left+right;
    }
}