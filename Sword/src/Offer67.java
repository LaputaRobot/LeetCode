public class Offer67 {
    public int strToInt(String str) {
        long res=0;
        boolean start=false;
        boolean isMinus=false;
        for (int i = 0; i < str.length(); i++) {
            if (!start){
                if (str.charAt(i)=='+') {
                    start=true;
                }
                else if (str.charAt(i)=='-'){
                    isMinus=true;
                    start=true;
                }
                else if (str.charAt(i)>='0'&&str.charAt(i)<='9') {
                    res=(str.charAt(i)-'0');
                    start = true;
                }
                else if (str.charAt(i)==' ') {
                }
                else return 0;
            }
            else if (str.charAt(i)>='0'&&str.charAt(i)<='9'){
                res=res*10+(str.charAt(i)-'0');
                if (res>Integer.MAX_VALUE) return isMinus?Integer.MIN_VALUE:Integer.MAX_VALUE;
            }
            else break;
        }
        if (isMinus)res=-res;
        return (int)res;
    }

    public static void main(String[] args) {
        System.out.println(new Offer67().strToInt("  2147483647     "));
    }
}
