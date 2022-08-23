public class LC459 {
    public boolean repeatedSubstringPattern(String s) {
        for (int n = 1; n <= s.length()/2; n++) {
            if (s.length()%n!=0)continue;
            for (int i = 0; i < n;i++) {
                int j=i+n;
                boolean f=true;
                while (j<s.length()){
                    if (s.charAt(j)!=s.charAt(j-n)){
                        f=false;
                       break;
                    }
                    if (j==s.length()-1) return true;
                    j+=n;
                }
                if (!f) break;
            }
        }
        return false;
    }

    public boolean repeatedSubstringPattern1(String s) {
        if (s.length()==1) return false;
        int j=0;
        int end=0;
        boolean f=false;
         for (int i = 0; i < s.length(); i++) {
            if (s.charAt(j)==s.charAt(i)){
                j++;
                if (j>end) {
                    j = 0;
                    f=true;
                }
            }else{
                end=i;
                j=0;
                f=false;
            }
        }
        return j==0&&f;
    }

    public static void main(String[] args) {
        System.out.println(new LC459().repeatedSubstringPattern("abacababacab"));
    }
}
