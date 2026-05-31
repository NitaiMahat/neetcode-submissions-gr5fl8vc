class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        /**
             must take b before taking a  [a,b]

        **/
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        int[] inDegree = new int[numCourses+1];
        for(int[] preReq : prerequisites){
            inDegree[preReq[0]]++;
            graph.get(preReq[1]).add(preReq[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                queue.add(i);
            }
        }
        int count = 0;
        while(!queue.isEmpty()){
            int currCourse = queue.poll();
            count++;
            for(int tempCourses : graph.get(currCourse)){
                inDegree[tempCourses]--;
                if(inDegree[tempCourses]==0){
                    queue.add(tempCourses);
                }
            }

        }


        return numCourses==count;

    }
}
