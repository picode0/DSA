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
    //Map<TreeNode, TreeNode> parent;
    public int sumEvenGrandparent(TreeNode root) {
        
        return dfs(root, -1,-1);
    }

    public int dfs(TreeNode root, int parent, int gParent){
        if(root==null)
            return 0;

        int val = gParent % 2 ==0?root.val:0;

        return val+dfs(root.left, root.val, parent)+dfs(root.right, root.val, parent);
    }
/*
    public int dfs(TreeNode root){
        if(root==null)
            return 0; 

        if(root.left!=null)
            parent.put(root.left, root);
        if(root.right!=null)
            parent.put(root.right, root);

        int val = 0; 

        if(parent.get(root)!=null && parent.get(parent.get(root))!=null){
            if(parent.get(parent.get(root)).val %2 ==0){
                val = root.val;
            }
        }
        return val+dfs(root.left)+dfs(root.right);
    }
*/
}