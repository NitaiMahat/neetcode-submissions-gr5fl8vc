class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree =  new int[numCourses];
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] pre : prerequisites){
            graph.get(pre[1]).add(pre[0]);
            inDegree[pre[0]]++;
        }
          List<Integer> tempList = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<inDegree.length;i++){
            if(inDegree[i]==0){
                queue.add(i);
                tempList.add(i);
            }
        }
      
        int count = 0;
        while(!queue.isEmpty()){
            int currCourse = queue.poll();
            count++;
            
            for(int preReq : graph.get(currCourse)){
                inDegree[preReq]--;
                if(inDegree[preReq]==0){
                    queue.add(preReq);
                    tempList.add(preReq);
                    
                }
            }
        }
        if(numCourses!=count){
            return new int[]{};
        }
        int[]  finalArr = new int[tempList.size()];
        for(int i=0;i<finalArr.length;i++){
            finalArr[i] = tempList.get(i);
        }
        return finalArr;
    }
}
