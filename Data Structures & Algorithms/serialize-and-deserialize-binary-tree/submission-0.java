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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return "";
        }
        StringBuilder newString = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode currNode = queue.poll();
            if(newString.length() >0){
                newString.append(",");
            }
            if(currNode==null){
                newString.append("n");
            }else{
                newString.append(currNode.val);
                queue.add(currNode.left);
                queue.add(currNode.right);
            }
            
          

        }
        return newString.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()){
            return null;
        }
        String[] splitData = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(splitData[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i=1;
        while(!queue.isEmpty() && i < splitData.length){
            TreeNode parent = queue.poll();

            if(i<splitData.length && !splitData[i].equals("n")){
                TreeNode left = new TreeNode(Integer.parseInt(splitData[i]));
                 parent.left = left;
                queue.add(left);
            }
            i++;

            if(i<splitData.length && !splitData[i].equals("n")){
                TreeNode right = new TreeNode(Integer.parseInt(splitData[i]));
                parent.right = right;
                queue.add(right);
            }
            i++;
        }
        return root;
    }
}
