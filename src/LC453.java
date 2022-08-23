import java.util.Arrays;

public class LC453 {
    public int minMoves(int[] nums) {
        int minNum= Arrays.stream(nums).min().getAsInt();
        int ans=0;
        for (int num : nums) {
            ans+=num-minNum;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4,5};
        System.out.println(new LC453().minMoves(nums));
    }
}
