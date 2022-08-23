public class Offer46 {
    public int translateNum(int num) {
        String numStr=""+num;
        int len=numStr.length();
        if (len<=1)return len;
        int a=1,b=1,c=0;
        for (int i = 1; i < len; i++) {
            if (canBeChar(numStr.charAt(i-1),numStr.charAt(i))){
                if (i==1) {
                    c = 2;
                    b = 2;
                }
                else c=a+b;
            }
            else c=b;
            if (i>1) {
                a = b;
                b = c;
            }
        }
        return c;
    }
    public boolean canBeChar(char x,char y){
        if (x=='0'||x>'2') return false;
        else if (x=='1') return true;
        else {
            return y <= '5';
        }
    }
    public static void main(String[] args) {
        int num=100;
        System.out.println(new Offer46().translateNum(num));
    }
}
