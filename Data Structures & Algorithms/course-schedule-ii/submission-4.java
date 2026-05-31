class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        int[] inDegree = new int[numCourses+1];
        for(int[] preReq : prerequisites){
            inDegree[preReq[0]]++;
            graph.get(preReq[1]).add(preReq[0]);

        }
        List<Integer> tempList = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                queue.add(i);
                tempList.add(i);
            }
        }

        
        int count = 0;
        while(!queue.isEmpty()){
            int currCourse = queue.poll();
            count++;
            for(int tempCourse : graph.get(currCourse)){
                inDegree[tempCourse]--;
                if(inDegree[tempCourse]==0){
                    queue.add(tempCourse);
                    tempList.add(tempCourse);
                }
            }
        }
        if(count!=numCourses){
            return new int[]{};
        }
        int[] finalArr = new int[tempList.size()];
        for(int i=0;i<tempList.size();i++){
            finalArr[i] = tempList.get(i);
        }
        return finalArr;
    }
}
