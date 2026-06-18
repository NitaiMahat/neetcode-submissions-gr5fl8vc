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
        /**
            cloneMap to keep ttrack of copiedNode so later when i tr to add neighbors i dont duplicte node

        **/
        if(node==null){
            return null;
        }
        Map<Node,Node> cloneMap = new HashMap<>();
        Node copyNode = new Node(node.val);
        Queue<Node> queue = new LinkedList<>();
        cloneMap.put(node,copyNode);
        queue.add(node);
        while(!queue.isEmpty()){
            Node currNode = queue.poll();
            Node currCopy = cloneMap.get(currNode);
            for(Node neigh : currNode.neighbors){
                Node loopNode;
                if(cloneMap.containsKey(neigh)){
                    loopNode = cloneMap.get(neigh);
                }else{
                    queue.add(neigh);
                    loopNode = new Node(neigh.val);
                    cloneMap.put(neigh,loopNode);
                }
                currCopy.neighbors.add(loopNode);
                
            }
        }
        return cloneMap.get(node);
    }
}