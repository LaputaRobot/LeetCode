public class lc704 {
    public static int search(int[] nums, int target) {
        int index=-1;
        int left=0,right=nums.length-1;
        int mid=(left+right)/2;
        while (left<=right){
            mid=(left+right)/2;
            int num=nums[mid];
            if (target>num){
                left=mid+1;
            }
            else if (target<num){
                right=mid-1;
            }
        }
        if (target>nums[right]||target<nums[left]) index=-1;
        else index=mid;
        return index;
    }
    public static void main(String[] args) {
        int[] nums=new int[]{-1,0,3,5,9,12};
        int target = 12;
        System.out.println(search(nums,target));
    }
}
