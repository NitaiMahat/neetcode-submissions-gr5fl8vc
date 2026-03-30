class Solution {
    public int countComponents(int n, int[][] edges) {
        if(n==0){
            return 0;
        }
        List<List<Integer>> graph = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int component = 0;
        for(int i=0;i<n;i++){
            if(!visited.contains(i)){
                component++;
                dfs(i,graph,visited);
            }
        }
        return component;


    }
    private void dfs(int curr, List<List<Integer>> graph, Set<Integer> visited){
        if(visited.contains(curr)){
            return;
        }
        visited.add(curr);
        for(int next : graph.get(curr)){
            dfs(next,graph,visited);
        }
    }
}
