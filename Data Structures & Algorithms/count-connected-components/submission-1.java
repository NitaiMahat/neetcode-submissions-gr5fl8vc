class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        Set<Integer> seenSet = new HashSet<>();
        int count = 0;

        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int component = 0;
        for(int i=0;i<n;i++){
            if(!seenSet.contains(i)){
                component++;
                dfs(i,graph,seenSet);
            }
        }
        return component;
        


    }
    private void dfs(int curr , List<List<Integer>> edges , Set<Integer> seenSet){
        if(seenSet.contains(curr)){
            return;
        }
        seenSet.add(curr);
        for(int next : edges.get(curr)){
            dfs(next,edges,seenSet);
        }
    }
}
