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
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        cloneMap.put(node, new Node(node.val));
        while(!queue.isEmpty()){
            Node ogNode = queue.poll();
            Node cloneNode = cloneMap.get(ogNode);
            for(Node currOg: ogNode.neighbors){
                Node currClone;
                if(cloneMap.containsKey(currOg)){
                    currClone =  cloneMap.get(currOg);
                }else{
                    queue.add(currOg);
                    cloneMap.put(currOg, new Node(currOg.val));
                    currClone = cloneMap.get(currOg);
                }
                cloneNode.neighbors.add(currClone);

            }
        }
        return cloneMap.get(node);
    }
}