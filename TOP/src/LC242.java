public class LC242 {
    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length())return false;
        int[] help=new int[26];
        for (int i = 0; i < s.length(); i++) {
            help[s.charAt(i)-'a']+=1;
        }
        for (int i = 0; i < t.length(); i++) {
            int index=t.charAt(i)-'a';
            help[index]-=1;
            if (help[index]<0)return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new LC242().isAnagram("a","a"));
    }
}
