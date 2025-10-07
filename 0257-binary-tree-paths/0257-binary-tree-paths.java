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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<>(); 
        StringBuilder sb = new StringBuilder();
        dfs(ret, root, sb);
        return ret;
    }

    public void dfs(List<String> list, TreeNode root, StringBuilder sb){

        if(root==null)
            return;

        sb.append(root.val);
        if(root.left==null && root.right==null){
            list.add(sb.toString());
            return;
        }
        int length = sb.length();
        sb.append("->");
        String s = sb.toString();
        dfs(list, root.left, sb);
        sb.setLength(length+2);
        dfs(list, root.right, sb);
        //sb.setLength(length);

    }
}