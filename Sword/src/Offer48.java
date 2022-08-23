import java.util.HashMap;

public class Offer48 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> record=new HashMap<>();
        int res=0;
        int left=0;
        for (int i = 0; i < s.length(); i++) {
            int before=record.getOrDefault(s.charAt(i),-1);
            if (before>=left) left=before+1;
            record.put(s.charAt(i),i);
            if (i-left+1>res) res=i-left+1;
        }
        return res;
    }

    public static void main(String[] args) {
        String s="pjogj-kovre-gregk-dkvorgkrwwkew";
        System.out.println(new Offer48().lengthOfLongestSubstring(s));
    }
}
