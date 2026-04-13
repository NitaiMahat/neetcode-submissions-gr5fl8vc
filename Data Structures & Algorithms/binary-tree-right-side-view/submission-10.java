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
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null){
            return new ArrayList<>();

        }
        List<Integer> finalList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size-1;i++){
                TreeNode temp = queue.remove();
                if(temp.left!=null){
                    queue.add(temp.left);
                }
                if(temp.right!=null){
                    queue.add(temp.right);
                }

            }
            TreeNode rightNode = queue.remove();
            if(rightNode.left!=null){
                    queue.add(rightNode.left);
                }
            if(rightNode.right!=null){
                    queue.add(rightNode.right);
                }
                finalList.add(rightNode.val);

        }
        return finalList;
    }
}
