class Solution {
      /**
            target = 10;
            position = [1,4]
            speed = [3,2]

            10/3 = 4
            4/2 = 2
            4+2+2+2
            1+3+3+3
            10/2 - >

            10-1 9/3->3
            10-4 6/2->3

            fleet+= 1
            10-1 = 9/2 = 4
            target = 10, 
            position = [4,1,0,7],  0,1,4,7  ->  10-7 3/1 = 3  10-4 6/2 -> 3
                                   1 2 2 1
            speed =   [2,2,1,1]

            so my though sorting it going form backwards checking the time it takes
            storing time lets say in hashset if i find same time that means car feelt 
            and i dont duplciate however one cna be its own car feelt so i add unseen also
        **/
    public int carFleet(int target, int[] position, int[] speed) {
      int[][] carsArr = new int[position.length][2];
      for(int i=0;i<position.length;i++){
        carsArr[i][0] = position[i];
        carsArr[i][1] = speed[i];
      }
      Arrays.sort(carsArr,(a,b) -> a[0]-b[0]);

      int carFleet =0;
      double prevTime = 0;
      for(int i=carsArr.length-1;i>=0;i--){
        int currPos = carsArr[i][0];
        int currSpeed = carsArr[i][1];
        double timeTaken = (target-currPos)/(double) currSpeed;
        if(prevTime < timeTaken){
            carFleet++;
            prevTime = timeTaken;
        }

      }
      return carFleet;
    }
}
