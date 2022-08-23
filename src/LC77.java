import java.util.*;

public class LC77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result=new ArrayList<>();
        if (k <= 0 || n < k) {
            return result;
        }
        Stack<Integer> path=new Stack<>();
        dfs(n,k,1, path,result);
        return  result;
    }
    public void dfs(int n,int k, int start,Stack<Integer> path,List<List<Integer>> res){
        if (path.size()==k){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= n-(k-path.size())+1; i++) {
            path.push(i);
            dfs(n,k,i+1,path,res);
            path.pop();
        }
    }

    public static void main(String[] args) {
        LC77 lc77=new LC77();
        System.out.println(lc77.combine(4,2));
    }
}
