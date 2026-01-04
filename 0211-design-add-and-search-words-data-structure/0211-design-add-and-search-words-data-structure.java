class TrieNode{
    boolean isLast;
    TrieNode[] children;
    TrieNode(){
        isLast = false;
        children = new TrieNode[26];
    }
}

class WordDictionary {
    TrieNode root; 
    public WordDictionary() {
        root = new TrieNode();

    }
    
    public void addWord(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()){
            if(curr.children[c-'a']==null)
                curr.children[c-'a'] = new TrieNode();
            curr = curr.children[c-'a']; 
        }
        curr.isLast = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        return searchHelper(word, root, 0);
    }

    public boolean searchHelper(String word, TrieNode node, int idx){
        if(idx==word.length())
            return node.isLast;
        
        char c = word.charAt(idx);

        if(c=='.'){
            for(TrieNode child: node.children){
                if(child!=null && searchHelper(word, child, idx+1))
                    return true;
            }
            return false;
        }
        
        if(node.children[c-'a']==null)
            return false;

        return searchHelper(word, node.children[c-'a'], idx+1);

    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */