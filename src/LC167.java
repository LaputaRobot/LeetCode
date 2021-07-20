import java.util.Arrays;

public class LC167 {
    public static int[] twoSum(int[] numbers, int target) {
        int left=0,right=numbers.length-1;
        int sum=numbers[left]+numbers[right];
        while (sum!=target){
            if (sum<target) left++;
            else if (sum>target) right--;
            else break;
            sum=numbers[left]+numbers[right];
        }
        return new int[]{left+1,right+1};
    }
    public static void main(String[] args) {
        int[] nums=new int[]{-1,0};
        int target=-1;
        System.out.println(Arrays.toString(twoSum(nums,target)));
    }
}
