class Solution {

    public boolean validTree(int n, int[][] edges) {
        
        if(n==0){
            return true;
        }
        if(edges.length != n-1){
            return false;
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

        boolean noCycle = dfs(0,visited,graph);
        return noCycle == true && visited.size()==n;
    }

    private boolean dfs(int currNode, Set<Integer> visited, List<List<Integer>> graph){
        if(visited.contains(currNode)){
            return false;
        }
        visited.add(currNode);
        for(int chimeki : graph.get(currNode)){
            dfs(chimeki,visited,graph);
        }
        return true;
    }
}
