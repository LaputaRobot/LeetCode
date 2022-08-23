import java.util.ArrayList;
import java.util.List;

public class LC412 {
    public List<String> fizzBuzz(int n) {
        List<String> res=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i<=5){
                if ((i+1)%3==0) res.add("Fizz");
                else if ((i+1)%5==0) res.add("Buzz");
                else res.add(""+(i+1));
            }
            else {
                if (res.get(i-3).equals("Fizz")&&(res.get(i-5).equals("Buzz"))) {
                    res.add("FizzBuzz");
                }
                else if (res.get(i-3).equals("FizzBuzz")&&(!res.get(i-5).equals("Buzz"))) res.add("Fizz");
                else if (res.get(i-5).equals("FizzBuzz")&&(!res.get(i-3).equals("Fizz"))) res.add("Buzz");
                else {
                    if (res.get(i-3).equals("Fizz")) res.add("Fizz");
                    else if (res.get(i-5).equals("Buzz")) res.add("Buzz");
                    else res.add(""+(i+1));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LC412().fizzBuzz(100));
    }
}
