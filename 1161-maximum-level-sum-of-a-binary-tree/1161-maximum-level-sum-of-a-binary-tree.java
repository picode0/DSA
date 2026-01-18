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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int maxSum = Integer.MIN_VALUE, ret = 0, level = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            int currSum = 0;
            for(int i=0;i<size;i++){
                TreeNode poll = queue.poll();
                currSum += poll.val;
                if(poll.left!=null)
                    queue.offer(poll.left);
                if(poll.right!=null)
                    queue.offer(poll.right);
            }
            if(currSum > maxSum){
                maxSum = currSum;
                ret = level;
            }
            level++;
        }
        return ret; 
    }
}