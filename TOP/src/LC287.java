public class LC287 {
    public int findDuplicate(int[] nums) {
        int left=1,right=nums.length-1;
        int mid=1;
        while (left<=right){
            mid=(left+right)/2;
            int times1=0;
            int times2=0;
            for (int num : nums) {
                if (num < mid) times1++;
                if (num == mid) times2++;
            }
            if (times1>mid-1) right=mid-1;
            else{
                if (times2>1)return mid;
                else left=mid+1;
            }
        }
        return mid;
    }
    public int findDuplicate1(int[] nums) {
        int slow=0,fast=0;
        do {
            slow=nums[slow];
            fast=nums[nums[fast]];
        }while (slow!=fast);
        int h=0;
        while (h!=slow){
            h=nums[h];
            slow=nums[slow];
        }
        return slow;
    }
    public static void main(String[] args) {
        System.out.println(new LC287().findDuplicate1(new int[]{1,3,4,2,2}));
    }
}
