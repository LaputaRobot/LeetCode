public class LC326 {
    public boolean isPowerOfThree(int n) {
        return false;
    }

    public static void main(String[] args) {
        int num = 1;
        int len = 1;
        while (len < 10) {
            num *= 3;
            len = 0;
            int tmp = num;
            while (tmp > 0) {
                len ++;
                tmp /=10;
            }
            System.out.println(num);
        }
//        System.out.println(new LC326().isPowerOfThree(99));
    }
}

