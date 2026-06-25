class BrowserHistory {
    Stack<String> future;
    Stack<String> history;
    String curr;
    // 
    // 6,5,4,3,2,1
    public BrowserHistory(String homepage) {
        future = new Stack<>();
        history = new Stack<>(); 
    
        curr = homepage;

    }
    
    public void visit(String url) {
        history.push(curr);
        future.clear();
        curr = url;
    }
    
    public String back(int steps) {
        int n = steps;
        while(!history.isEmpty() && n>0){
            future.push(curr);
            curr = history.pop();
            n--;
        }
        return curr;

    }
    
    public String forward(int steps) {
        int n = steps;
        while(!future.isEmpty() && n>0){
            history.push(curr);
            curr = future.pop();
            n--;
        }
        return curr;
    }
}
//fd = kttzxgh crqje iybch unn

//bk =  
//tip cgrt esgriv

//fd = leetcode 
//bk = linnkedin fb 
// curr == google 

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */