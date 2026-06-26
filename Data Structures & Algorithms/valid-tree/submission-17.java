class Solution {
    private int[] parent;
    private int[] rank;
    public boolean validTree(int n, int[][] edges) {
        if(edges.length !=n-1){
            return false;
        }
        parent = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
            rank[i] = 1;
        }
        for(int[] edge: edges){
            int rootA = find(edge[0]);
            int rootB = find(edge[1]);
            if(rootA==rootB){
                return false;
            }
            union(rootA,rootB);
        }
        return true;

    }
    private int find(int node){
        while(parent[node]!=node){
            node = parent[node];
        }
        return node;
    }
    private void union(int rootA,int rootB){
        if(rank[rootA] > rank[rootB]){
            parent[rootB] = rootA;
        }else if(rank[rootB]> rank[rootA]){
            parent[rootA] = rootB;
        }else{
            parent[rootB] = rootA;
            rank[rootA]++;
        }
    }
}
