public class LC91 {
    public int numDecodings(String s) {
//        if (s.length()==1&&s.charAt(0)=='0') return 0;
        int a=1,b=1;
        if (s.charAt(0)=='0'){
            a=0;
            b=0;
        }
        for (int i = 1; i < s.length(); i++) {
            if (canContact(s.charAt(i-1),s.charAt(i))){
                if (s.charAt(i)=='0'){
                    b=a;
                    a=0;
                }
                else {
                    int tmp = b;
                    b = b + a;
                    a = tmp;
                }
            }
            else if (s.charAt(i)=='0') {
                return 0;
            }else{
                a = b;
            }
            if (a==0&&b==0) break;
        }
        return b;
    }
    public boolean canContact(char ch1,char ch2){
        if (ch1=='1') return true;
        else if (ch1=='2') return ch2<'7';
        return false;
    }
    public static void main(String[] args) {
        System.out.println(new LC91().numDecodings("0"));
    }
}
