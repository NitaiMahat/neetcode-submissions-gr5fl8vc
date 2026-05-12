class Solution {
    private int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length+1];
        for(int i=0;i<=edges.length;i++){
            parent[i] = i;
        }
        for(int[] edge : edges){
            if(find(edge[0])==find(edge[1])){
                return edge;
            }
            union(edge[0],edge[1]);
        }
        return null;
    }
    private int find(int edge){
        while(parent[edge]!= edge){
            edge = parent[edge];
        }
        return edge;
    }
    private void union(int edge1 , int edge2){
        int root1 = find(edge1);
        int root2 = find(edge2);
        if(root1!=root2){
            parent[root2] = root1;
        }
    }
}
