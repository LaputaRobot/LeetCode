import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;
class WordDictionary {
    HashMap<Long, ArrayList<String>> map=new HashMap<Long, ArrayList<String>>();
    public WordDictionary() {
    }
    private long getHashCode(String word){
        long code=0;
        for (int i = 0; i < word.length(); i++) {
            code+=(word.charAt(i));
        }
        return code;
    }
    public void addWord(String word) {
        long code=getHashCode(word);
        if (map.containsKey(code)){
            map.get(code).add(word);
        }
        else {
            ArrayList<String> list=new ArrayList<String>();
            list.add(word);
            map.put(code,list);
        }
    }
    public boolean search(String word) {
        if (word.contains(".")){

        }else {
            long code = getHashCode(word);
            if (map.containsKey(code)) {
                return map.get(code).contains(word);
            }
        }
        return false;
    }
}
public class LC211 {
    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("abd");
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad")); // return False
        System.out.println(wordDictionary.search("bad")); // return True
        System.out.println(wordDictionary.search(".ad")); // return True
        System.out.println(wordDictionary.search("b..")); // return True
    }
}
