public class LC162 {
    public int findPeakElement(int[] nums) {
        if(nums.length==1) return 0;
        int start = 0, end = nums.length - 1;
        return findPeakElementH(nums, start, end);
    }

    public int findPeakElementH(int[] nums, int start, int end) {
        if (start > end) return -1;
        int mid = (start + end) / 2;
        if (mid == 0 && nums[mid] > nums[mid + 1]) return mid;
        if (mid == nums.length - 1 && nums[mid] > nums[mid - 1]) return mid;
        if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) return mid;
        int res = findPeakElementH(nums, start, mid - 1);
        if (res == -1) return findPeakElementH(nums, mid + 1, end);
        else return res;
    }

    public static void main(String[] args) {
        LC162 lc162 = new LC162();
        int[] nums = new int[]{2,1};
        System.out.println(lc162.findPeakElement(nums));
    }
}
