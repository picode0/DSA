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
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    public boolean helper(TreeNode root, Integer maxval, Integer minval){
        if(root==null)
            return true;
        
        if(maxval!=null && root.val >= maxval || minval!=null && root.val <= minval)
            return false;
        
        return helper(root.left, root.val, minval) && helper(root.right, maxval, root.val);
        
    }

}