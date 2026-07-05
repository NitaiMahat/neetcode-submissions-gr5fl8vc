class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStack() {
      stack = new Stack<>();
      minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty()){
            minStack.push(val);
        }else{
            if(minStack.peek() >= val){
                minStack.push(val);
            }
        }
    }
    
    public void pop() {
        if(!stack.isEmpty()){
             int popedValue = stack.pop();
        if(!minStack.isEmpty()){
             if(minStack.peek()==popedValue){
            minStack.pop();
        }
        }
        }
       
       
    }
    
    public int top() {
        if(!stack.isEmpty()){
            return stack.peek();
        }
        return -1;
    }
    
    public int getMin() {
        if(!minStack.isEmpty()){
            return minStack.peek();
        }
        return -1;
        
    }
}
