class Node{
    Node prev;
    Node next;
    int key;
    int val;
    Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    Map<Integer, Node> map;
    int capacity;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            removeKey(node);
            put(key, node.val);
            return node.val;
        }
        else    
            return -1;

    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            removeKey(node);
            //addLast(new Node(key,value));
        }
        Node newNode = new Node(key, value);
     
        addLast(newNode);
        map.put(key, newNode);

        if(map.size() > capacity){
            map.remove(head.next.key);
            removeKey(head.next);
        }
    }

    public void removeKey(Node node){
        //Node temp = node.prev; 
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addLast(Node node){
        Node temp = tail.prev;
        temp.next = node;
        node.prev = temp;
        node.next = tail;
        tail.prev = node;

    }


}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */