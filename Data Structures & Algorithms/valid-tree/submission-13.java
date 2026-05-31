class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(n-1 != edges.length){
            return false;
        }
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<=n-1;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(0);
        while(!queue.isEmpty()){
            int currEdge = queue.poll();
            visited.add(currEdge);
            for(int num : graph.get(currEdge)){
                if(!visited.contains(num)){
                    queue.add(num);
                }
            }

        }
        return visited.size() == n;

    }
}
