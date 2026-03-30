class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> finalListTemp = new ArrayList<>();
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
            finalListTemp.add(curr);
            List<Integer> temp = graph.get(curr);
            for(int prereq : temp){
                
                inDegree[prereq]--;
                if(inDegree[prereq]==0){
                    queue.add(prereq);
                }
            }
        }
        int[] temp11 = new int[0];
        if(count!=numCourses){
            return  temp11;
        }
        int[] finalArray = new int[finalListTemp.size()+1];
        for(int i=0;i<finalListTemp.size();i++){
            finalArray[i] = finalListTemp.get(i);
        }
        finalArray[finalArray.length-1]= finalArray.length-1;
        return finalArray;

    }
        
    
}
