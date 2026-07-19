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
        Map<Node,Node> cloneMap = new HashMap<>();
        if(node==null){
            return null;
        }
        Node newNode = new Node(node.val);
        cloneMap.put(node,newNode);
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            Node currNode = queue.poll();
            Node copyNode = cloneMap.get(currNode);
            for(Node neigh : currNode.neighbors){
                Node loopNode;
                if(cloneMap.containsKey(neigh)){
                    loopNode = cloneMap.get(neigh);
                }else{
                    loopNode = new Node(neigh.val);
                    cloneMap.put(neigh,loopNode);
                    queue.add(neigh);
                }
                copyNode.neighbors.add(loopNode);
            }
        }
        return newNode;
    }
}