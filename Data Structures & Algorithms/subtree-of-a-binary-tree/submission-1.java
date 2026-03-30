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
        String first = preOrder(root);
        String second = preOrder(subRoot);
        return first.contains(second);
    }
    private String preOrder(TreeNode node){
        if(node==null){
            return "null";
        }
        StringBuilder stringVal = new StringBuilder();
        stringVal.append(node.val);
        stringVal.append(preOrder(node.left));
        stringVal.append(preOrder(node.right));

        return stringVal.toString();
    }

}
