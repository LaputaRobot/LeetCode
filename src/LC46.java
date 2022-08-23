import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LC46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        dfs(nums, 0, path, res);
        return res;
    }

    public void dfs(int[] nums, int start, ArrayList<Integer> path, List<List<Integer>> res) {
        if (start == nums.length) {
            res.add(new ArrayList<>(path));
        }
        for (int i = start; i < nums.length; i++) {
            exchange(nums, i, start);
            path.add(nums[start]);
            dfs(nums, start+1, path, res);
            path.remove(path.size() - 1);
            exchange(nums, i, start);
        }
    }

    public void exchange(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        LC46 lc46 = new LC46();
        int[] nums = new int[]{1, 2, 3,4};
        System.out.println(lc46.permute(nums));
    }
}
