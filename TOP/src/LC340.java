import java.util.HashMap;

public class LC340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k==0) return 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int res = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            hashMap.put(ch, hashMap.getOrDefault(ch, 0)+1);
            while (hashMap.size() > k) {
                char dCha = s.charAt(left);
                hashMap.put(dCha, hashMap.get(dCha) - 1);
                if (hashMap.get(dCha) == 0) {
                    hashMap.remove(dCha);
                }
                left++;
            }
            if (i - left+1 > res) res = i - left+1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LC340().lengthOfLongestSubstringKDistinct("ececeba", 2));
    }
}
