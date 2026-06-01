class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        //buildign graph table
        Map<Integer,List<int[]>> graph = new HashMap<>();
        for(int[] time : times){
            int source = time[0];
            int target = time[1];
            int weight  = time[2];
            if(!graph.containsKey(source)){
                graph.put(source,new ArrayList<>());
            }
            graph.get(source).add(new int[] {target,weight});
        }
        //defining min heap
        Queue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        Set<Integer> visited = new HashSet<>();
        minHeap.add(new int[] {k,0});
        int result = 0;
        while(!minHeap.isEmpty()){
            int[] top = minHeap.poll();
            int src = top[0];
            int srcWeight = top[1];
            if(visited.contains(src)){
                continue;
            }
            result = srcWeight;
            visited.add(src);
            if(!graph.containsKey(src)){
                continue;
            }
            for(int[] edge : graph.get(src)){
                int tar = edge[0];
                int tarWeight = edge[1];
                minHeap.add(new int[] {tar,srcWeight+tarWeight});
            }

        }
        if(visited.size()==n){
            return result;
        }
        return -1;

    }
}
