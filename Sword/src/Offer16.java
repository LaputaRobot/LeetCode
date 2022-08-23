import java.util.TreeMap;

public class Offer16 {
    TreeMap<Integer,Double> record=new TreeMap<>();
    public double myPow(double x, int n) {
        if (n==0) return 1;
        if (n==Integer.MIN_VALUE) {
            return 1/(helper(x,-(n+1))*x);
        }
        if(n<0) return 1/helper(x,-n);
        else return helper(x,n);
    }

    public double helper(double x, int n) {
        if (n==1) return x;
        if (record.containsKey(n)) return record.get(n);
        if (n%2==0) {
            double res=helper(x, n / 2) * helper(x, n / 2);
            if (!record.containsKey(n)) record.put(n,res);
            return res;
        }
        else {
            double res=helper(x, n / 2) * helper(x, n / 2)*x;
            if (!record.containsKey(n)) record.put(n,res);
            return res;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Offer16().myPow(1.00000001,-2147483648));
//        System.out.println(-(Integer.MIN_VALUE+1));
    }
}
