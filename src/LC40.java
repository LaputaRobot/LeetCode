import java.util.*;

public class LC40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res=new ArrayList<>();
        Deque<Integer> tmp=new ArrayDeque<>();
        combination(candidates,target,0,res,tmp);
        return res;
    }
    public void combination(int[] candidates, int target,int start,List<List<Integer>> res,Deque<Integer> tmp) {
        if (target==0){
            res.add(new ArrayList<>(tmp));
            return;
        }
        int last=-1;
        for (int i = start; i < candidates.length; i++) {
            if (last==candidates[i])continue;
            last=candidates[i];
            if (target-candidates[i]<0)return;
            tmp.add(candidates[i]);
            combination(candidates,target-candidates[i],i+1,res,tmp);
            tmp.removeLast();
        }
    }
    public static void main(String[] args) {
        System.out.println(new LC40().combinationSum2(new int[]{10,1,1,1,2,2,2,2,7,6,1,5},8));
    }
}
