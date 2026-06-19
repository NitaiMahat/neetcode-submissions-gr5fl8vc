class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge : prerequisites){
            graph.get(edge[1]).add(edge[0]);
            inDegree[edge[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<inDegree.length;i++){
            if(inDegree[i]==0){
                queue.add(i);
            }
        }
        int count = 0;
        while(!queue.isEmpty()){
            int currCourse = queue.poll();
            count++;
            for(int pre : graph.get(currCourse)){
                inDegree[pre]--;
                if(inDegree[pre]==0){
                    queue.add(pre);
                }
            }

        }
        return count==numCourses;

    }
}
