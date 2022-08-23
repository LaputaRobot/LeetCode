import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Offer50 {
    public char firstUniqChar(String s) {
        HashMap<Character,Integer> record=new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            record.put(s.charAt(i),record.getOrDefault(s.charAt(i),0)+1);
        }
        for (Map.Entry entry : record.entrySet()) {
            if ((int)entry.getValue()==1) return (char) entry.getKey();
        }
        return ' ';
    }

    public static void main(String[] args) {
        String s="leetccoddetlo";
        System.out.println(new Offer50().firstUniqChar(s));
    }
}
