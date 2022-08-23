class Trie {
    // 前缀匹配树的实现
    private Trie[] children;
    private boolean isEnd;
    public Trie() {
        children=new Trie[26];
        isEnd=false;
    }

    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch=word.charAt(i);
            int index=ch-'a';
            if (node.children[index]==null){
                node.children[index]=new Trie();
            }
            node=node.children[index];
        }
        node.isEnd=true;
    }

    public boolean search(String word) {
        return word.length()==prefixNumber(this,word,0);
    }

    public boolean startsWith(String prefix) {
        return prefix.length()<=prefixNumber(this,prefix,0);
    }
    public int prefixNumber(Trie node,String word,int i){
        if (node==null) return -1;
        if (i>word.length()) return 1;
        else if (i==word.length()) {
            if (node.isEnd)
            return 0;
            else return 1;
        }
        else {
            char ch = word.charAt(i);
            int index = ch - 'a';
            return prefixNumber(node.children[index], word, i + 1)+1;
        }
    }
}
public class LC208 {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("ab");
        trie.insert("abcdef");
        System.out.println(trie.search("ab"));
        System.out.println(trie.search("abcdef"));
        System.out.println(trie.startsWith("ab"));
    }
}
