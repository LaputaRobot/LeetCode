public class LC169 {
    public int majorityElement(int[] nums) {
        int res=0;
        int time=0;
        for (int num : nums) {
            if (time == 0) {
                res = num;
                time++;
            } else {
                if (res == num) time++;
                else time--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LC169().majorityElement(new int[]{13,1}));
    }
}
