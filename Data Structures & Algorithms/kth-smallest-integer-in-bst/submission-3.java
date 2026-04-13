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
    private List<Integer> orderList = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        if(root==null){
            return 0;
        }
        dfs(root);
        if(k>orderList.size()){
            return 0;
        }
        return orderList.get(k-1);
    }
    private void dfs(TreeNode root){
        if(root==null){
            return;
        }
        dfs(root.left);
        orderList.add(root.val);
        dfs(root.right);
    }
}
