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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        /**
            preorder = root left right
            inorder = left root right

        **/
        Map<Integer,Integer> inorderMap = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inorderMap.put(inorder[i],i);
        }
        return splitTree(preorder,inorder,inorderMap,0,0,preorder.length-1);
    }
    private TreeNode splitTree(int[] preorder,int[] inorder,Map<Integer,Integer> inorderMap ,int rootIndex,int left,int right){
        TreeNode newNode = new TreeNode(preorder[rootIndex]);
        int mid = inorderMap.get(preorder[rootIndex]);
        if(mid > left){
            newNode.left = splitTree(preorder,inorder,inorderMap,rootIndex+1,left,mid-1);
        }
        if(mid < right){
            newNode.right = splitTree(preorder,inorder,inorderMap,rootIndex+(mid-left)+1,mid+1,right);
        }
        return newNode;

    }
}
