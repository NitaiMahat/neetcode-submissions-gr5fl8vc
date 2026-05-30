/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        //edge case
        //null
        if(node==null){
            return null;
        }
        Map<Node,Node> cloneMap = new HashMap<>();
       
        Node copyNode = new Node(node.val);
        cloneMap.put(node,copyNode);
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            Node currNode = queue.poll();
            Node ogNode = cloneMap.get(currNode);
            for(Node neighb : currNode.neighbors){
                Node loopNode;
                if(cloneMap.containsKey(neighb)){
                    loopNode = cloneMap.get(neighb);
                }else{
                     queue.add(neighb);
                    loopNode = new Node(neighb.val);
                    
                    cloneMap.put(neighb,loopNode);
                }
                ogNode.neighbors.add(loopNode);
               
            }
        }
        return cloneMap.get(node);
    }
}