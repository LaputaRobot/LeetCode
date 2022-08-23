public class LC125 {
    public boolean isPalindrome(String s) {
        int l=0,r=s.length()-1;
        while (l<r){
            char ch1=s.charAt(l);
            while (!((ch1>='A'&&ch1<='Z')||(ch1>='a'&&ch1<='z')||(ch1>='0'&&ch1<='9'))) {
                l++;
                if (l>=r)return true;
                ch1=s.charAt(l);
            }
            char ch2=s.charAt(r);
            while (!((ch2>='A'&&ch2<='Z')||(ch2>='a'&&ch2<='z')||(ch2>='0'&&ch2<='9'))) {
                r--;
                if (l>=r)return true;
                ch2=s.charAt(r);
            }
            if (ch1>='A'&&ch1<='Z') ch1= (char) ('a'+(ch1-'A'));
            if (ch2>='A'&&ch2<='Z') ch2= (char) ('a'+(ch2-'A'));
            if (ch1!=ch2) return false;
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new LC125().isPalindrome("@@"));
    }
}
