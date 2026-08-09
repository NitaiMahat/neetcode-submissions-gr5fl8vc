class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        /**

                4 +2 +2 +2
                double target-postion / speed = time
                10-7/1 = 3

                COMBINE = postion[i], speed[i];
                Stack = 3
        **/
        int[][] combine = new int[position.length][2];
        for(int i=0;i<position.length;i++){
            combine[i][0] = position[i];
            combine[i][1] = speed[i];
        }
        Stack<Double> stack = new Stack<>();
        Arrays.sort(combine, (a,b) -> a[0] - b[0]);
        for(int i=combine.length-1;i>=0;i--){
            double currArrivalTime = (double) (target-combine[i][0])/(double) combine[i][1];
            if(!stack.isEmpty() && currArrivalTime <=stack.peek()){
                continue;
            }else{
                stack.push(currArrivalTime);
            }
        }
        return stack.size();



    }
}
