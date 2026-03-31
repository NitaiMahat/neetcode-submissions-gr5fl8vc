class Solution {
    public boolean validTree(int n, int[][] edges) {
       if(edges.length !=n-1){
        return false;
       }
        List<List<Integer>> graph = new ArrayList<>();
        
 
        Set<Integer> seen = new HashSet<>();

        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge:edges){

            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);

            
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        seen.add(0);
      
        while(!queue.isEmpty()){
            int curr = queue.poll();
           
            List<Integer> temp = graph.get(curr);
            for(int next : temp){
                if(!seen.contains(next)){
                      seen.add(next);
                    queue.add(next);
                }
                  
                
            }
        }
         return  seen.size() == n;
        
      
    }
   
      
}

