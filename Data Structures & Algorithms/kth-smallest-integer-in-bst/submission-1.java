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
    List<Integer> currentList = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        dfs(root,k);
        if(k <= currentList.size()){
            return currentList.get(k-1);
        }
        return 0;
    }
    private void dfs(TreeNode root, int k){
        if(root==null){
            return;
        }
        dfs(root.left,k);
        currentList.add(root.val);
        dfs(root.right,k);
        

    }
}
