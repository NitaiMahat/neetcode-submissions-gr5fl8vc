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
    List<Integer> checkList = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        dfs(root); 
        for(int i=0;i<checkList.size()-1;i++){
            if(checkList.get(i) >= checkList.get(i+1)){
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
        checkList.add(root.val);
         dfs(root.right);
        

    }

}
