class Solution {
    int[] parent;
    int[] rank;
    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length+1];
        rank = new int[edges.length+1];
        if(edges==null || edges.length==0){
            return new int[]{};
        }
        for(int i=0;i<edges.length;i++){
            parent[i] = i;
            rank[i] = 1;
        }

        for(int[] edge : edges){
            int rootA = find(edge[0]);
            int rootB = find(edge[1]);

            if(rootA == rootB){
                return edge;
            }
            union(rootA,rootB);
        }
        return new int[]{};
    }
    private int find(int node){
        while(parent[node]!=node){
            node = parent[node];
        }
        return node;
    }
    private void union(int rootA , int rootB){
        if(rank[rootA] > rank[rootB]){
            parent[rootB] = rootA;
        }else if(rank[rootA] < rank[rootB]){
            parent[rootA] = rootB;
        }else{
            parent[rootB] = rootA;
            rank[rootA]++;
        }
    }
}
