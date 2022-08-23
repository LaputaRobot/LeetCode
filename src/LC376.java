import java.util.ArrayList;

public class LC376 {
    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;
        int[] up = new int[len];
        int[] down = new int[len];
        up[0] = 1;
        down[0] = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] < nums[i - 1]) {
                down[i] = down[i - 1];
                up[i] = Math.max(up[i - 1], down[i - 1] + 1);
            } else if (nums[i] > nums[i - 1]) {
                up[i] = up[i - 1];
                down[i] = Math.max(down[i - 1], up[i - 1] + 1);
            } else {
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            }
        }
        return Math.max(up[len - 1], down[len - 1]);
    }

    public int wiggleMaxLength1(int[] nums) {
        int len = nums.length;
        int lastUp=1;
        int lastDown=1;
        for (int i = 1; i < len; i++) {
            if (nums[i] < nums[i - 1]) {
                lastUp = Math.max(lastUp, lastDown + 1);
            } else if (nums[i] > nums[i - 1]) {
                lastDown = Math.max(lastDown, lastUp + 1);
            }
        }
        return Math.max(lastDown, lastUp);
    }
    public int wiggleMaxLength3(int[] nums) {
        int n = nums.length;

        // 1. 长度为1的都是摆动序列
        if(n < 2){
            return n;
        }
        // 2. 初始化
        int prevdiff = nums[1] - nums[0];        // 记录相邻三个元素 x y z(x 和 y 的差是正还是负)
        int ret = prevdiff != 0?2:1;             // 前两个元素是否有重复
        // 3. 贪心遍历数组:加入一个新元素
        ArrayList<Integer> list=new ArrayList<>();
        for(int i = 2;i < n;i++){
            int diff = nums[i] - nums[i - 1];   // 记录相邻三个元素 x y z(y 和 z 的差是正还是负)
            if((diff > 0 && prevdiff <= 0) || (diff < 0 && prevdiff >= 0)){  // 判断当前序列的上升下降趋势
                list.add(nums[i]);
                ret++;                          // 如果出现了「峰」或「谷」，答案加一
                prevdiff = diff;                // 更新当前序列的上升下降趋势
            }
        }
        System.out.println(list);
        return ret; // 返回结果
    }
    public static void main(String[] args) {
        System.out.println(new LC376().wiggleMaxLength3(new int[]{1,17,5,10,13,15,10,5,16,8}));
    }
}

