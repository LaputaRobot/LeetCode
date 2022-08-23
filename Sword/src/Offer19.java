public class Offer19 {
    public boolean isMatch(String s, String p) {
        int j=0;
        char last=p.charAt(j);
        for (int i = 0; i < s.length(); i++) {
            last=p.charAt(j);
            if (p.charAt(j+1)=='*') {
                if (last=='.'||s.charAt(i)==last) continue;
                else {
                    j += 2;
                    i--;
                }
            }
            else {
                if (last=='.'||s.charAt(i)==last) j++;
                else return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s="abbbabcabbbabc";
        String p=".*b.*bac";
        System.out.println(new Offer19().isMatch(s,p));
    }
}
