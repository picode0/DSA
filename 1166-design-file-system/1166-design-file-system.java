class FileSystem {
    Map<String, Integer> map;
    public FileSystem() {
        map = new HashMap<>();
        map.put("", -1);
    }
    
    public boolean createPath(String path, int value) {
        String parent = path.substring(0, path.lastIndexOf("/"));
        if(map.containsKey(path) || !map.containsKey(parent))
            return false;
        
        map.put(path, value);
        return true;
    }
    
    public int get(String path) {
        return map.containsKey(path)?map.get(path):-1;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */