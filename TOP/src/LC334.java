import java.util.Arrays;

public class LC334 {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        int first = nums[0], second = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            if (num > second) {
                return true;
            } else if (num > first) {
                second = num;
            } else {
                first = num;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new LC334().increasingTriplet(new int[]{1,2,1,2,1,2}));
    }
}
