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
    List<Integer> finalList = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        dfs(root);
        for(int i=0;i<finalList.size()-1;i++){
            if(finalList.get(i) >= finalList.get(i+1)){
                return false;
            }
        }
        return true;
    }
    private void dfs(TreeNode root){
        if(root==null){
            return;
        }
        dfs(root.left);
        finalList.add(root.val);
        dfs(root.right);

    }
}
