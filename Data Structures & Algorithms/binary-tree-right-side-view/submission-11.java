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
        List<Integer> finalList = new ArrayList<>();
        if(root==null){
            return finalList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size-1;i++){
                TreeNode throwAwayNode = queue.poll();
                if(throwAwayNode.left != null){
                    queue.add(throwAwayNode.left);
                }
                if(throwAwayNode.right != null){
                    queue.add(throwAwayNode.right);
                }
            }
            TreeNode rightNode = queue.poll();
            finalList.add(rightNode.val);
            if(rightNode.left != null){
                    queue.add(rightNode.left);
                }
                if(rightNode.right != null){
                    queue.add(rightNode.right);
                }
        }
        return finalList;
    }
}
