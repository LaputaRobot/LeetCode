import java.util.Arrays;

public class Offer17 {
    public int[] printNumbers(int n) {
        int max=1;
        while (n>0) {
            n--;
            max*=10;
        }
        int[ ] res=new int[max-1];
        for (int i = 1; i < max; i++) {
            res[i-1]=i;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Offer17().printNumbers(3)));
    }
}
