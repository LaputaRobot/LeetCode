import java.util.HashSet;
import java.util.Set;

public class LC202 {
    public boolean isHappy(int n) {
        Set<Integer> set=new HashSet<>();
        set.add(n);
        while (true){
            int tmp=0;
            while (n!=0){
                int m=n%10;
                tmp+=m*m;
                n/=10;
            }
            n=tmp;
            if (tmp==1)return true;
            if (set.contains(tmp))break;
            set.add(n);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new LC202().isHappy(19));
    }
}
