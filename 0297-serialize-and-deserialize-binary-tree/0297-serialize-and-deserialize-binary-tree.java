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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        queue.offer(root);
        // ,1,2,Null,Null
        // q = 3 
        while(!queue.isEmpty()){
            TreeNode poll = queue.poll();
            if(poll==null){
                sb.append("Null,");
                continue;
            }
            sb.append(poll.val+ ",");
            queue.offer(poll.left);
            queue.offer(poll.right);

        }
        //System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //System.out.println(data);
        String[] dataToArr = data.split(",");
        if(dataToArr[0].equals("Null"))
            return null;
        Queue<TreeNode> queue = new LinkedList<>();

        int idx = 1; 
        TreeNode ret = new TreeNode(Integer.valueOf(dataToArr[0]));
        queue.offer(ret);

        while(!queue.isEmpty() && idx < dataToArr.length){
            TreeNode poll = queue.poll();
            if(!dataToArr[idx].equals("Null")){
                poll.left = new TreeNode(Integer.valueOf(dataToArr[idx]));
                queue.offer(poll.left);
            }
            idx++;
            if(idx<dataToArr.length && !dataToArr[idx].equals("Null")){
                poll.right = new TreeNode(Integer.valueOf(dataToArr[idx]));
                queue.offer(poll.right);
            }
            idx++;
        }
        return ret;

    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));