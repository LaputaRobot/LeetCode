public class Offer03 {
    public int findRepeatNumber(int[] nums) {
        int[] flags=new int[nums.length];
        for (int num : nums) {
            if (flags[num] == 0) flags[num] = 1;
            else return num;
        }
        return 0;
    }
    public int findRepeatNumber1(int[] nums) {
        int i=0;
        while (i < nums.length ) {
            if (nums[i]==i) {
                i++;
                continue;
            }
            if (nums[nums[i]]==nums[i]) return nums[i];
            else {
                int tmp=nums[i];
                nums[i]=nums[tmp];
                nums[tmp]=tmp ;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        System.out.println(new Offer03().findRepeatNumber1(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }
}
