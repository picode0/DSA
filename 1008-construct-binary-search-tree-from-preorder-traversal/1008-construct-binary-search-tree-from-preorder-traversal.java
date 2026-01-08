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
    int idx;
    
    public TreeNode bstFromPreorder(int[] preorder) {
        idx = 0;
        return helper(preorder, Integer.MAX_VALUE);
    }

    public TreeNode helper(int[] preorder, int upper){
        if(idx==preorder.length || preorder[idx] > upper)
            return null;

        TreeNode ret = new TreeNode(preorder[idx++]);
        ret.left = helper(preorder, ret.val);
        ret.right = helper(preorder, upper);

        return ret;

        
    }
}