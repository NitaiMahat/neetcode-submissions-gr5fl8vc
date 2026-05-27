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
        if(node==null){
            return null;
        }
        Map<Node,Node> cloneMap = new HashMap<>();
 
        cloneMap.put(node,new Node(node.val));
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            Node currNode = queue.poll();
            Node currCloneNode = cloneMap.get(currNode);
            for(Node loopNode : currNode.neighbors){
                Node loopClone;
                if(cloneMap.containsKey(loopNode)){
                    loopClone = cloneMap.get(loopNode);
                }else{
                    queue.add(loopNode);
                    cloneMap.put(loopNode,new Node(loopNode.val));
                    loopClone = cloneMap.get(loopNode);
                }
                currCloneNode.neighbors.add(loopClone);
            }

        }
        return cloneMap.get(node);

    }
}