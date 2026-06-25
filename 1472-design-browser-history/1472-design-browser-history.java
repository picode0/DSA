class DLNode{
    String st;
    DLNode prev;
    DLNode next;
    public DLNode(String st){
        this.st = st;
        prev = null;
        next = null;
    }
}

class BrowserHistory {
    DLNode node;

    public BrowserHistory(String homepage) {
        node = new DLNode(homepage);
    }
    
    public void visit(String url) {
        DLNode newNode = new DLNode(url);
        node.next = newNode;
        newNode.prev = node;
        node = node.next;
    }
    
    public String back(int steps) {
        int n = steps;
        while(node.prev!=null && n>0){
            node = node.prev;
            n--;
        }
        return node.st;
    }
    
    public String forward(int steps) {
        int n = steps;
        while(node.next!=null && n>0){
            node = node.next;
            n--;
        }
        return node.st;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */