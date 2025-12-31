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
    int ret;
    public int maxPathSum(TreeNode root) {
        ret = Integer.MIN_VALUE;
        dfs(root);

        return ret; 
    }

    public int dfs(TreeNode root){
        if(root==null)
            return 0;
        
        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));
        
        ret = Math.max(ret, root.val + left + right);
        return Math.max(left,right) + root.val;
    }
}