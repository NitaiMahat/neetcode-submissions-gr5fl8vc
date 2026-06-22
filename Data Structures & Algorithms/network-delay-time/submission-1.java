class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
      
        Map<Integer,List<int[]>> graph = new HashMap<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        for(int[] time:times){
            int source = time[0];
            int target = time[1];
            int weight = time[2];
            if(!graph.containsKey(source)){
                graph.put(source,new ArrayList<>());
            }
            graph.get(source).add(new int[]{target,weight});
        }
        Set<Integer> visited = new HashSet<>();
        queue.add(new int[]{k,0});
        int result = 0;
        while(!queue.isEmpty()){
            int[] currNode = queue.poll();
            int src = currNode[0];
            int srcWeight = currNode[1];
            if(visited.contains(src)){
                continue;
            }
            result = srcWeight;
            visited.add(src);
            if(!graph.containsKey(src)){
                continue;
            }
            for(int[] targetArr : graph.get(src)){
                int tar = targetArr[0];
                int tarWeight = targetArr[1];

                queue.add(new int[]{tar,tarWeight+srcWeight});
            }
        }
        if(visited.size()==n){
            return result;
        }
        return -1;

    }
}
