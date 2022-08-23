public class LC08 {
    public int myAtoi(String s) {
        long res=0;
        boolean isNegative=false;
        boolean started=false;
        for (int i = 0; i < s.length(); i++) {
            char ch=s.charAt(i);
            if (!started) {
                if (ch == ' ') continue;
                else if (ch=='-'){
                    started=true;
                    isNegative=true;
                }
                else if (ch=='+'){
                    started=true;
                }
                else if (ch>='0'&&ch<='9'){
                    started=true;
                    res=ch-'0';
                }
                else return 0;
            }
            else {
                if (ch>='0'&&ch<='9') res=res*10+ch-'0';
                else break;
                if (res-1>Integer.MAX_VALUE) break;
            }
        }
        if (isNegative) {
            return -res<Integer.MIN_VALUE?Integer.MIN_VALUE: (int) -res;
        }
        return res>Integer.MAX_VALUE?Integer.MAX_VALUE: (int) res;
    }

    public static void main(String[] args) {
        System.out.println(new LC08().myAtoi(" 0036499 with words"));
    }

}
