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
    //int ret = 0;
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);

    }

    public int dfs(TreeNode root, int sum){
        //System.out.println(root.val);
        if(root==null)
            return 0;

        if(root.left==null && root.right==null){
            return sum*10 + root.val;
        }
        
        return dfs(root.left, sum*10 + root.val) +  dfs(root.right, sum*10 + root.val);
        
    }
}