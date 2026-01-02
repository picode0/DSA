/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    int idx;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //StringBuilder sb = new StringBuilder();

        if(root==null)
            return "null";
        
        //System.out.println(root.val);
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        String[] dataToArr = data.split(",");
        //System.out.println("len " + dataToArr.length);
        
        idx = 0;
        return dsHelper(dataToArr);
    }

    public TreeNode dsHelper(String[] arr) {

        if(arr[idx].equals("null")){
            idx++;
            return null;
        }

        TreeNode newNode = new TreeNode(Integer.valueOf(arr[idx]));
        idx++;
        newNode.left = dsHelper(arr);
        newNode.right = dsHelper(arr);

        return newNode;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));