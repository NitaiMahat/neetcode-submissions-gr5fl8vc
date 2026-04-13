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
    private int count = 1;
    public int goodNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        dfs(root.left,root,root.val);
        dfs(root.right,root,root.val);
        return count;
    }
    private void dfs(TreeNode root,TreeNode ogRoot,int currParent){
        if(root==null){
            return;
        }
        if(root.val >= ogRoot.val && root.val>=currParent){
            count++;
        }
        dfs(root.left, ogRoot,Math.max(currParent,root.val));
        dfs(root.right,ogRoot,Math.max(currParent,root.val));





    }
}
