class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] preReqTrack = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            graph.get(pre[1]).add(pre[0]);
            preReqTrack[pre[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(preReqTrack[i]==0){
                queue.add(i);
            }
        }

        List<Integer> temp = new ArrayList<>();
        while(!queue.isEmpty()){
            int curr = queue.poll();
            temp.add(curr);
            for(int next : graph.get(curr)){
                preReqTrack[next]--;
                if(preReqTrack[next]==0){
                    queue.offer(next);
                }
                
            }
        }
        if(temp.size()==numCourses){
            int[] result = new int[numCourses];
            for(int i=0;i<temp.size();i++){
                result[i] = temp.get(i);
            }
            return result;
        }else{
            return new int[0];
        }
        
    }
}
