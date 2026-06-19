class Solution {
    private int[] parent;
    private int[] rank;
    public int countComponents(int n, int[][] edges) {
        int component = n;
        parent = new int[n];
        rank = new int[n];

        for(int i=0;i<n;i++){
            parent[i] = i;
            rank[i] = 1;
        }
        for(int[] edge: edges){
            if(union(edge[0],edge[1])){
                component--;
            }
        }
        return component;

        
    }
    private boolean union(int edgeA , int edgeB){
        int rootA = find(edgeA);
        int rootB = find(edgeB);
        if(rootA==rootB){
            return false;
        }
        if(rank[rootB]> rank[rootA]){
            parent[rootA] =  rootB;
        }else if(rank[rootA]> rank[rootB]){
            parent[rootB] = rootA;
        }else{
            parent[rootB] = rootA;
            rank[rootA]++;
        }
        return true;


    }

    private int find(int node){
        while(parent[node]!=node){
            node = parent[node]; 
        }
        return node;
            
    }
}
