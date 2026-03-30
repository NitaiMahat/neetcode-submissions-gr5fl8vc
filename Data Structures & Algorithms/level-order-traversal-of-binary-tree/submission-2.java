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
        List<List<Integer>> finalList = new ArrayList<>();
        
       
        if(root==null){
            return finalList;
        }
         Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> currentList = new ArrayList<>();
            int level = queue.size();
            for(int i=0;i<level;i++){
                TreeNode temp = queue.poll();
                currentList.add(temp.val);
                if(temp.left !=null){
                     queue.add(temp.left);
                }
                if(temp.right !=null){
                     queue.add(temp.right);
                }
            }
            finalList.add(currentList);
           
           
        }
           return finalList;
    }
 
}
