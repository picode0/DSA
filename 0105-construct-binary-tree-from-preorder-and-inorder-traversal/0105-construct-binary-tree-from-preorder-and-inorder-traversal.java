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
    int preIdx;
    Map<Integer,Integer> inIdx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIdx = 0;
        inIdx = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            inIdx.put(inorder[i], i);
        
        return helper(preorder, 0, preorder.length-1);
    }

    public TreeNode helper(int[] preorder, int left, int right){
        if(left>right)
            return null;

        TreeNode ret = new TreeNode(preorder[preIdx++]);
        ret.left = helper(preorder, left, inIdx.get(ret.val)-1);
        ret.right = helper(preorder, inIdx.get(ret.val)+1, right);
        return ret; 
        
    }
}