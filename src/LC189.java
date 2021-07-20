import java.util.Arrays;

public class LC189 {
    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        int count = 0;
        int startIndex = 0;
        for (; count < len; startIndex++) {
            int nextIndex = (startIndex + k) % len;
            int tempS = nums[startIndex];
            int tempT;
            while (nextIndex != startIndex) {
                tempT = nums[nextIndex];
                nums[nextIndex] = tempS;
                tempS = tempT;
                nextIndex = (nextIndex + k)%len;
                count++;
            }
            nums[nextIndex]=tempS;
            count++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int k = 2;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}
