import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LC46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayDeque path = new ArrayDeque();
        for (int i = 0; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, path, res);
            path.removeLast();
        }
        return res;
    }

    public void dfs(int[] nums, ArrayDeque path, List res) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        } else {
            for (int num :
                    nums) {
                if (!path.contains(num)) {
                    path.addLast(num);
                    dfs(nums,path,res);
                    path.removeLast();
                }
            }
        }
    }

    public static void main(String[] args) {
        LC46 lc46=new LC46();
        int[] nums=new int[]{1,2};
        System.out.println(lc46.permute(nums));
    }
}
