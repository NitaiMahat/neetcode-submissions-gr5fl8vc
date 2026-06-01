class Solution {
     private int[] parent;
    private int[] rank;
    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length+1];
        rank = new int[edges.length+1];
       for(int i=0;i<=edges.length;i++){
            parent[i] = i;
            rank[i] = 1;
       }
       for(int[] edge : edges){
            int rootA = find(edge[0]);
            int rootB = find(edge[1]);

            if(rootA == rootB){
                return edge;
            }
            union(rootA ,rootB);
       }
       return new int[]{};

       
    }
    private int find(int node){
        while(parent[node]!=node){
            node = parent[node];
        }
        return node;
    }

    private boolean union(int a , int b){
        
        if(rank[a] > rank[b]){
            parent[b] = a;
            
        }else if(rank[a] < rank[b]){
            parent[a] = b;
        }else{
            parent[b] = a;
            rank[a]++;
        }
        return true;
    }
}
