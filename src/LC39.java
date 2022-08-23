import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> results=new ArrayList<>();
        ArrayList<Integer> res=new ArrayList<>();
        combination(results,res,candidates,target,0);
        return results;
    }
    public void combination(List<List<Integer>> results,ArrayList<Integer> res,int[] candidates, int target,int start){
        if (target==0) {
            results.add(new ArrayList<>(res));
            return;
        }
        for (int i = start; i<candidates.length&&target >= candidates[i]; i++) {
            res.add(candidates[i]);
            combination(results,res,candidates,target-candidates[i],i);
            res.remove(res.size()-1);
        }
    }

    public static void main(String[] args) {
        int[]  candidates = {2,3,5} ;
        int target = 8;
        System.out.println(new LC39().combinationSum(candidates,target));
    }
}
