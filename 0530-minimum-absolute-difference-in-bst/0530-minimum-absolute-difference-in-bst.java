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
    int ret= Integer.MAX_VALUE;
    TreeNode prev;
    public int getMinimumDifference(TreeNode root) {
        
        dfs(root);

        return ret;
    }
    public void dfs(TreeNode root){
        if(root==null)
            return;
        
        dfs(root.left);
        if(prev!=null)
            ret = Math.min(ret, Math.abs(root.val - prev.val));
        prev = root;
        dfs(root.right);
        
        
    }
}