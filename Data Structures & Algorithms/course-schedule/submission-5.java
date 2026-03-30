class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        /**
            plan: map menaing a list , queue , store count of the prerequisistes in map
            store non prereqesites in queue and then traverse

        **/
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        int[] inDegree = new int[numCourses];

        for(int[] prereq : prerequisites){
            graph.get(prereq[1]).add(prereq[0]);
            inDegree[prereq[0]]++;
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
            List<Integer> temp = graph.get(curr);
            for(int prereq : temp){
                
                inDegree[prereq]--;
                if(inDegree[prereq]==0){
                    queue.add(prereq);
                }
            }
        }
        return count==numCourses;

    }
}
