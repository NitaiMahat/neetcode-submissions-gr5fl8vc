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
            root left right
            left root right

        **/
        Map<Integer,Integer> inorderIndexMap = new HashMap<>();

        for(int i=0;i<inorder.length;i++){
            inorderIndexMap.put(inorder[i],i);
        }
        return splitTree(preorder,inorderIndexMap,0,0,preorder.length-1);



    }
    private TreeNode splitTree(int[] preorder, Map<Integer,Integer> map , int rootIndex,int left,int right){
        TreeNode rootNode = new TreeNode(preorder[rootIndex]);
        int mid = map.get(preorder[rootIndex]);
        if(mid > left){
            rootNode.left = splitTree(preorder,map,rootIndex+1,left,mid-1);
        }
        if(mid<right){
            rootNode.right = splitTree(preorder,map,rootIndex+(mid-left)+1, mid+1  , right);
        }
        return rootNode;
    }
}
