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

    public boolean isValidBST(TreeNode root) {
        List<Integer> inorderList = new ArrayList<>();
        if(root==null){
            return true;
        }    
        dfs(root,inorderList);
        for(int i=0;i<inorderList.size()-1;i++){
            if(inorderList.get(i) >= inorderList.get(i+1)){
                return false;
            }
        }
        return true;
    }
    private void dfs(TreeNode root,List<Integer> inorderList){
        if(root==null){
            return;
        }
        dfs(root.left,inorderList);
        inorderList.add(root.val);
        dfs(root.right,inorderList);
    }
}
