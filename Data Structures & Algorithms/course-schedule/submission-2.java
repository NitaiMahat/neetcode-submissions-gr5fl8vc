class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] preRecTrack = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        //num of couses = 3 then the grpah will ahve 3 empty lsit;
         // [0,1] 
        //[ [],[],[] ]
        //   0  1  2
        for(int[] pre : prerequisites){
            graph.get(pre[1]).add(pre[0]);
            //[ [],[0],[] ]
        //      0   1  2
        // preRecTrack = [1,0,0]
            preRecTrack[pre[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(preRecTrack[i]==0){
                queue.offer(i);
            }
        }

        int count =0;
        while(!queue.isEmpty()){
            int curr = queue.poll();
            count++;
            for(int next : graph.get(curr)){
                preRecTrack[next]--;
                if(preRecTrack[next]==0){
                    queue.offer(next);
                }
            }
        }
        return count== numCourses;

    }
}
