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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        String first = dfs(root);
        String second = dfs(subRoot);

        return first.contains(second);
    }

    private String dfs(TreeNode root){
        if(root==null){
            return "null";
        }

        StringBuilder sb = new StringBuilder();

        sb.append(root.val);
        sb.append(dfs(root.left));
        sb.append(dfs(root.right));
        return sb.toString();
    }
}
