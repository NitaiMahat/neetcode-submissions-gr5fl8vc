class Solution {
    public boolean validTree(int n, int[][] edges) {
        //no cycle / no repretation;
        if(n-1!=edges.length){
            return false;
        }
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge :edges){
            int key = edge[0];
            int child = edge[1];
            graph.get(key).add(child);
            graph.get(child).add(key);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        Set<Integer> visited = new HashSet<>();
        while(!queue.isEmpty()){
            int currNode = queue.poll();
            visited.add(currNode);
            for(int num : graph.get(currNode)){
                if(!visited.contains(num)){
                    queue.add(num);
                }
            }
        }
        return n==visited.size();
    }
}
