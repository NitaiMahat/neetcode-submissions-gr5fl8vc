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
    private int goodNode = 1;
    public int goodNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        dfs(root.left,root.val);
        dfs(root.right,root.val);
        return goodNode;

    }
    private TreeNode dfs(TreeNode root,int maxSeenSoFar){
        if(root==null){
            return root;
        }
        if(root.val >= maxSeenSoFar){
            maxSeenSoFar = root.val;
            goodNode++;
        }
        dfs(root.left,maxSeenSoFar);
         dfs(root.right,maxSeenSoFar);
        return root;

    }
}
