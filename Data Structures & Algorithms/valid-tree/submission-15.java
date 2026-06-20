class Solution {
    public boolean validTree(int n, int[][] edges) {
        //bfs
        //with set for identifying duplicates
        if(n-1!=edges.length){
            return false;
        }
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());

        }
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while(!queue.isEmpty()){
            int curr = queue.poll();
            visited.add(curr);
            for(int pre : graph.get(curr)){
                if(!visited.contains(pre)){
                    queue.add(pre);
                }

            }
        }
        return n==visited.size();
    }
}
