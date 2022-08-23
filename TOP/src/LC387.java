public class LC387 {
    public int firstUniqChar(String s) {
        int[] record=new int[26];
        for (int i = 0; i < s.length(); i++) {
            record[s.charAt(i)-'a']+=1;
        }
        for (int i = 0; i < s.length(); i++) {
            if (record[s.charAt(i)-'a']==1)return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new LC387().firstUniqChar("lovveleetcoddetc"));
    }
}
