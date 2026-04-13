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
    private int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        longestPath(root);
         return diameter;
    }
    private int longestPath(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftHeight = longestPath(root.left);
        int rightHeight = longestPath(root.right);

        diameter = Math.max(diameter,leftHeight+rightHeight);
        return 1 +  Math.max(leftHeight,rightHeight);


    }
}
