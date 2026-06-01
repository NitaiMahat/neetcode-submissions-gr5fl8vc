class Solution {
    private int[] parent;
    private int[] rank;
    public int countComponents(int n, int[][] edges) {
         parent = new int[n];
         rank = new int[n];

        for(int i=0;i<n;i++){
            parent[i] = i;
            rank[i] = 1;
        }
        int component = n;
        for(int[] edge:edges){
            int a = edge[0];
            int b = edge[1];
            if(union(a,b)){
                component--;
            }
        }
        return component;
    }
    private int find(int node){
        while(parent[node]!=node){
            node = parent[node];
        }
        return node;
    }
    private boolean union(int a,int b){
        int rootA = find(a);
        int rootB = find(b);

        if(rootA==rootB){
            return false;
        }
        if(rank[rootA] > rank[rootB]){
            parent[rootB] = rootA;
        }else if(rank[rootA]< rank[rootB]){
            parent[rootA] = rootB;
        }else{
            parent[rootB] = rootA;
            rank[rootA]++;
        }
        return true;

    }
}
