class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int count = 0;
        double[][] time  = new double[position.length][2];
        for(int i=0;i<position.length;i++){
            double arrivalTime = (target-position[i])/ (double) speed[i];
            time[i][0] = position[i];
            time[i][1] = arrivalTime;
        }
        Arrays.sort(time, (a,b) -> Double.compare(a[0],b[0]) );
        Stack<Double> stack = new Stack<>();
        for(int i=position.length-1;i>=0;i--){
            if(stack.isEmpty()){
                stack.push(time[i][1]);
            }else{
                if(time[i][1] > stack.peek()){
                    stack.push(time[i][1]);
                }
            }

        }
        return stack.size();
    }
}
