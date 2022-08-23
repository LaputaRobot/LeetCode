import java.util.*;

public class LC216 {
    public static void main(String[] args) {
        System.out.println(new LC216().combinationSum3(9,45));
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res=new ArrayList<>();
        ArrayList<Integer> com=new ArrayList<>();
        combinationSum3(k,n,1,0,res,com);
        return res;
    }
    public void combinationSum3(int k, int n,int start,int sum,List<List<Integer>> res,ArrayList<Integer> com) {
        if (k==com.size()){
            if (sum==n)
                res.add(new ArrayList<>(com));
            return;
        }
        for (int i = start; i <= 9-k+1+com.size(); i++) {
            com.add(i);
            sum+=i;
            combinationSum3(k,n,i+1,sum,res,com);
            com.remove(com.size()-1);
            sum-=i;
        }
    }
}
