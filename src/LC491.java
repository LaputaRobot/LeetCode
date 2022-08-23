import java.util.ArrayList;
import java.util.List;

public class LC491 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        dfs(nums, 0, res, tmp);
        return res;
    }

    public void dfs(int[] nums, int start, List<List<Integer>> res, ArrayList<Integer> tmp) {
        if (start > nums.length - 1) return;
        int[] flags=new int[201];
        for (int i = start; i < nums.length; i++) {
            if (i > start && flags[nums[i]+100] == 1) continue;
            if (tmp.size() > 0 &&nums[i]<tmp.get(tmp.size()-1))continue;
            tmp.add(nums[i]);
            flags[nums[i]+100]=1;
            if (tmp.size() > 1)
                res.add(new ArrayList<>(tmp));
            dfs(nums, i + 1, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new LC491().findSubsequences(new int[]{4,3,7,7}));
    }
}
