class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> studentsQueue = new LinkedList<>();
        Stack<Integer> sandwichesStack = new Stack<>();
        for(int student : students){
            studentsQueue.add(student);
        }
        for(int i=sandwiches.length-1;i>=0;i--){
            sandwichesStack.push(sandwiches[i]);
        }
        int unable = 0;
        while(!studentsQueue.isEmpty() && unable !=studentsQueue.size()){
            if(studentsQueue.peek() == sandwichesStack.peek()){
                studentsQueue.remove();
                sandwichesStack.pop();
                unable = 0;
            }else{
                int studentsUnable = studentsQueue.remove();
                studentsQueue.add(studentsUnable);
                unable++;
                if(studentsQueue.size()==unable){
                    return unable;
                }
            }

        }
        
        return unable;


    }
}