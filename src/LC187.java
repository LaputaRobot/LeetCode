import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC187 {
    Map<Character,Integer> dict=new HashMap<Character,Integer>(){{
        put('A',0);
        put('C',1);
        put('G',2);
        put('T',3);
    }};
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res=new ArrayList<>();
        Map<String,Integer> map=new HashMap<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String subString=s.substring(i,i+10);
            if (!map.containsKey(subString)){
                map.put(subString,1);
            }
            else map.replace(subString,map.get(subString)+1);
        }
        for (String subStr:map.keySet() ) {
            if (map.get(subStr)>1)res.add(subStr);
        }
        return res;
    }
    public int getHash(int last,char newChar) {
        return ((last<<2)|dict.get(newChar))& ((1 << 20) - 1);
    }

    public List<String> findRepeatedDnaSequencesG(String s) {
        int L=10;
        List<String> res=new ArrayList<>();
        if(s.length()<10) return res;
        Map<Integer,Integer> map=new HashMap<>();
        int last=0;
        for (int i = 0; i < 10; i++) {
            last=(last<<2)|dict.get(s.charAt(i));
        }
        map.put(last,map.getOrDefault(last,0)+1);
        for (int i = 10; i < s.length() ; i++) {
            last=getHash(last,s.charAt(i));
            map.put(last,map.getOrDefault(last,0)+1);
            if (map.get(last)==2) {
                res.add(s.substring(i - 9, i+1));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "AAAAAAAAAA";
        System.out.println(new LC187().findRepeatedDnaSequencesG(s));
//        int hash=1;/
//        System.out.println((hash<<2)|1);
    }
}
