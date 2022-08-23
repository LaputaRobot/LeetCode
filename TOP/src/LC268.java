public class LC268 {
    public int missingNumber(int[] nums) {
        int sum=nums.length*(nums.length+1)/2;
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new LC268().missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
    }
}
