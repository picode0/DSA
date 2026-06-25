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
    boolean pfound = false, qfound = false;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ret = DFS(root, p, q);

        if(pfound && qfound)
            return ret;
            
        return null;
    }

    public TreeNode DFS(TreeNode root, TreeNode p, TreeNode q){
        if(root==null)
            return null;

        TreeNode left = DFS(root.left, p, q);
        TreeNode right = DFS(root.right, p,q);

        if(root==p){
            pfound = true;
            return root;
        }
        if(root==q){
            qfound = true;
            return root;
        }

        if(left!=null && right!=null)
            return root;
        
        return left==null?right:left;


    }

    /*
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
    */
}