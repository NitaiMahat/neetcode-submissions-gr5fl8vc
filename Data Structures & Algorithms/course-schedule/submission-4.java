class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        int[] inDegree = new int[numCourses];
        for(int[] preReq : prerequisites){
            graph.get(preReq[1]).add(preReq[0]);
            inDegree[preReq[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                queue.add(i);
            }
        }
        int count = 0;
        while(!queue.isEmpty()){
            int curr = queue.poll();
            count++;
            for(int next : graph.get(curr)){
                inDegree[next]--;
                if(inDegree[next]==0){
                    queue.add(next);
                }
            }
        }
        return count == numCourses;
    }
}
