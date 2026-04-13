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
        Map<Integer,Integer> inOrderIndexMap = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inOrderIndexMap.put(inorder[i],i);
        }
        return splitTree(preorder,inOrderIndexMap,0,0,inorder.length-1);

    }
    private TreeNode splitTree(int[] preorder,Map<Integer,Integer> inOrderIndexMap,int indexRoot,int left,int right){
        TreeNode rootNode = new TreeNode(preorder[indexRoot]);
        int mid = inOrderIndexMap.get(preorder[indexRoot]);
        if(mid >left){
            rootNode.left = splitTree(preorder,inOrderIndexMap,indexRoot+1,left,mid-1);
        }
        if(mid < right){
            rootNode.right = splitTree(preorder,inOrderIndexMap,indexRoot+ mid-left+1,mid+1,right);
        }
        return rootNode;
    }
}
