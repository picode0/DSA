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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ret = LCA(root, p, q);

        if(ret==p)
            return dfs(p,q)?p:null;
        if(ret==q)
            return dfs(q, p)?q:null;

        return ret;
    }

    public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || root==p || root==q)
            return root;

        TreeNode left = LCA(root.left, p, q);
        TreeNode right = LCA(root.right, p,q);

        if(left!=null && right!=null)
            return root;
        else if(left==null)
            return right;
        else 
            return left;
    }

    public boolean dfs(TreeNode p, TreeNode q){
        if(p == q)
            return true; 
        if(p==null)
            return false;

        return dfs(p.left, q) || dfs(p.right, q);
    }
}