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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        dfs(root, list);

        TreeNode ret = buildBalanced(list, 0, list.size()-1);

        return ret;
    }

    public void dfs(TreeNode root, List<Integer> list){
        if(root==null)
            return;
        
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }

    public TreeNode buildBalanced(List<Integer> list, int start, int end){
        /// 1 2 3 4
        if(start>end)
            return null;
        
        int mid = start + (end-start)/2;
        //System.out.println("start " + start + " end " + end + " mididx " + mid + " midval " + list.get(mid));
        TreeNode node = new TreeNode(list.get(mid));

        node.left = buildBalanced(list, start, mid-1);
        node.right = buildBalanced(list, mid+1, end);

        return node;
    }
}