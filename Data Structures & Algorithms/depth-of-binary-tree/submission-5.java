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
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        Queue<TreeNode> levelTreeNode = new LinkedList<>();
        levelTreeNode.add(root);
        int depth = 0;
        int left = 0;
        int right = 0;
        while(!levelTreeNode.isEmpty()){
            int size = levelTreeNode.size();
            for(int i=0;i<size;i++){
                 TreeNode temp = levelTreeNode.poll();
            if(temp.left !=null){
                levelTreeNode.add(temp.left);
               
             }
             if(temp.right!=null){
                 levelTreeNode.add(temp.right);
                }
               
            }
             depth++;
           
           
        }
        return depth;

    }
}
