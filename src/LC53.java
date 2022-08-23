public class LC53 {
    public int maxSubArray(int[] nums) {
        int res=Integer.MIN_VALUE;
        int sum=0;
        for (int num : nums) {
            sum += num;
            if (sum > res) res = sum;
            if (sum < 0) sum = 0;
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(new LC53().maxSubArray(new int[]{-4,-5,-2,-1}));
    }
}
