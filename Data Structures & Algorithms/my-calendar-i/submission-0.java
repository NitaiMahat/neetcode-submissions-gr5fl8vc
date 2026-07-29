class MyCalendar {
    List<int[]> list;
    public MyCalendar() {
        list = new ArrayList<>();
    }
    
    public boolean book(int startTime, int endTime) {
        for(int[] booking : list){
            int start = booking[0];
            int end = booking[1];

            if(end > startTime &&  endTime > start){
                return false;
            }

        }
        list.add(new int[]{startTime,endTime});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */