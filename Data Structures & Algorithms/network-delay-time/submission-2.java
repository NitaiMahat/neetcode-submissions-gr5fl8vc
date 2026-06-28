class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        if(times==null || times.length==0){
            return -1;
        }
        Map<Integer,List<int[]>> graph = new HashMap<>();
        for(int[] time : times){
            int src = time[0];
            int target = time[1];
            int srcWeight = time[2];
            if(!graph.containsKey(src)){
                graph.put(src,new ArrayList<>());
            }
            graph.get(src).add(new int[]{target,srcWeight});
        }
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        queue.add(new int[]{k,0});
        int result = 0;
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int src = curr[0];
            int srcWeight = curr[1];
            if(visited.contains(src)){
                continue;
            }
        result = srcWeight;
        visited.add(src);
        if(!graph.containsKey(src)){
            continue;
        }
        for(int[] temp : graph.get(src)){
            int target = temp[0];
            int targetWeight = temp[1];
            queue.add(new int[] {target,targetWeight+srcWeight});
        }
        }
        if(visited.size()==n){
            return result;
        }
        return -1;
    }
}
