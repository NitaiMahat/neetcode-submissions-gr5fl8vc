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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> finalList = new ArrayList<>();
        helper(root,finalList);
        return finalList;
    }
    private void helper(TreeNode root, List<Integer> finalList){
        if(root==null){
            return;
        }
        helper(root.left,finalList);
        finalList.add(root.val);
        helper(root.right,finalList);
    }
}