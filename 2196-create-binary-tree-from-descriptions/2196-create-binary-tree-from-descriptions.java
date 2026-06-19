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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();

        Set<Integer> child = new HashSet<>();

        for(int[] description: descriptions){
            map.putIfAbsent(description[0], new TreeNode(description[0]));
            map.putIfAbsent(description[1], new TreeNode(description[1]));

            if(description[2]==1)
                map.get(description[0]).left = map.get(description[1]);
            else
                map.get(description[0]).right = map.get(description[1]);
            
            child.add(description[1]);
        }

        for(TreeNode tree: map.values()){
            if(!child.contains(tree.val))
                return tree;
        }
        return null;
    }
}