public class Trie {
    private TrieNode root;
 
    public Trie() {
        root = new TrieNode();
    }
    // Inserts a word into the trie.
    public void insert(String word) {
        HashMap<Character, TrieNode> children = root.children;
 
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
 
            TrieNode t;
            if(children.containsKey(c)){
                    t = children.get(c);
            }else{
                t = new TrieNode(c);
                children.put(c, t);
            }
 
            children = t.children;
 
            //set leaf node
            if(i==word.length()-1)
                t.isLeaf = true;    
        }
    }
 
    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode t = searchNode(word);
 
        if(t != null && t.isLeaf) 
            return true;
        else
            return false;
    }
 
    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if(searchNode(prefix) == null) 
            return false;
        else
            return true;
    }
 
    public TrieNode searchNode(String str){
        Map<Character, TrieNode> children = root.children; 
        TrieNode t = null;
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(children.containsKey(c)){
                t = children.get(c);
                children = t.children;
            }else{
                return null;
            }
        }
 
        return t;
    }
}




class TrieNode{
    TrieNode[] arr;
    boolean isLeaf;
 
    public TrieNode(){
        arr = new TrieNode[26];
    }    
}
 
public class WordDictionary {
    TrieNode root;
 
    public WordDictionary(){
        root = new TrieNode();
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode p= root;
        for(int i=0; i<word.length(); i++){
            char c=word.charAt(i);
            int index = c-'a';
            if(p.arr[index]==null){
                TrieNode temp = new TrieNode();
                p.arr[index]=temp;
                p=temp;
            }else{
                p=p.arr[index];
            }
        }
        p.isLeaf=true;
    }
 
    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return dfsSearch(root, word, 0);     
    }
 
   public boolean dfsSearch(TrieNode p, String word, int start) {
        if (p.isLeaf && start == word.length())
            return true;
        if (start >= word.length())
            return false;
        char c = word.charAt(start);
        if (c == '.') {
            boolean tResult = false;
            for (int j = 0; j < 26; j++) {
                if (p.arr[j] != null) {
                    if (dfsSearch(p.arr[j], word, start + 1)) {
                        tResult = true;
                        break;
                    }
                }
            }
            if (tResult)
                return true;
        } else {
            int index = c - 'a';
 
            if (p.arr[index] != null) {
                return dfsSearch(p.arr[index], word, start + 1);
            } else {
                return false;
            }
        }
 
        return false;
    }
}
