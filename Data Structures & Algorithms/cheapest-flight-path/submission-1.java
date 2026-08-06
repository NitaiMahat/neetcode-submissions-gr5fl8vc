class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer,List<int[]>> graph = new HashMap<>();
        int[] bestStop = new int[n];
        Arrays.fill(bestStop, Integer.MAX_VALUE);
        for(int[] flight : flights){
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            if(!graph.containsKey(from)){
                graph.put(from,new ArrayList<>());
            }
            graph.get(from).add(new int[]{to,price});

        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) ->a[1]-b[1]);
       
        queue.add(new int[]{src,0,0});
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int airport = curr[0];
            int price = curr[1];
            int flightUsed = curr[2];

            if(flightUsed >k+1){
                continue;
            }
            if(bestStop[airport]<flightUsed){
                continue;
            }
            bestStop[airport] = flightUsed;
            if(airport == dst){
                return price;
            }
            
            if(!graph.containsKey(airport)){
                continue;
            }
            if(flightUsed ==k+1){
                continue;
            }
            for(int[] next :graph.get(airport)){
                int nextAirport = next[0];
                int nextPrice = next[1];
                queue.add(new int[]{nextAirport,nextPrice+price,flightUsed+1});
            }

        }
        return -1;
    }
}
