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
    public List<List<Integer>> levelOrder(TreeNode root) {
        /**
             queue sotre
             pop sotre children 
             poped value in list 
             reutn finalList at the end

        **/
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);
        List<List<Integer>> finalList = new ArrayList<>();
        while(!treeNodeQueue.isEmpty()){
            int size = treeNodeQueue.size();
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<size;i++){
                
                TreeNode popedNode = treeNodeQueue.poll();
                if(popedNode.left !=null){
                    treeNodeQueue.add(popedNode.left);
                 }
                if(popedNode.right !=null){
                    treeNodeQueue.add(popedNode.right);
                 }
                 temp.add(popedNode.val);
            }
            finalList.add(temp);
            
        }
        return finalList;
    }
}
