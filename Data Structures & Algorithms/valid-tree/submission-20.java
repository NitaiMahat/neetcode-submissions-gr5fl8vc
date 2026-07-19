class Solution {
    int[] parent;
    int[] rank;
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
        for(int[] edge : edges){
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
        while(node != parent[node]){
            node = parent[node];
        }
        return node;
    }
    private void union(int x , int y){
        if(rank[x]>rank[y]){
            parent[y] =x;
        }else if(rank[y]>rank[x]){
            parent[x] = y;
        }else{
            parent[y] = x;
            rank[x]++;
        }
    }
}
