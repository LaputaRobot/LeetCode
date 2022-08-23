import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC166 {
    public String fractionToDecimal(int numerator, int denominator) {
        boolean isMinus= (numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0);
        long num=numerator;
        long de=denominator;
        if (num<0) num=-num;
        if (de<0) de=-de;
        long before=num/de;
        long remainder=num%de;
        String res=""+before;
        if (remainder==0) {
            if (isMinus) res="-"+res;
            return res;
        }
        Map<Long,Long> map=new HashMap<>();
        map.put(remainder, 0L);
        StringBuilder stringBuilder=new StringBuilder();
        boolean isCircle=false;
        int index=0;
        while (remainder!=0){
            num=remainder*10;
            before=num/de;
            remainder=num%de;
            stringBuilder.append(before);
            if (map.containsKey(remainder)) {
                isCircle=true;
                break;
            }else map.put(remainder, (long) ++index);
        }
        if (isCircle){
            res=res+"."+ stringBuilder.substring(0, Math.toIntExact(map.get(remainder)))+"("+stringBuilder.substring(Math.toIntExact(map.get(remainder)),index+1) +")";
        }
        else res=res+"."+ stringBuilder;
        if (isMinus) res="-"+res;
        return res;
    }

    public static void main(String[] args) {
        int num=Integer.MIN_VALUE;
        int de=Integer.MIN_VALUE/2;
        System.out.println(num);
        System.out.println(de);
        System.out.println(new LC166().fractionToDecimal(Integer.MIN_VALUE,Integer.MIN_VALUE/2));
    }
}
