public class LC9 {
    /***
     * 改进：反转到一半就判断
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        int X=x;
        int Y=0;
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        while (x>Y){
            Y=Y*10+x%10;
            x/=10;
        }
        return Y==x||x==Y/10;
    }

    public static void main(String[] args) {
        System.out.println(new LC9().isPalindrome(10));
    }
}
