public class LC41 {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>nums.length||nums[i]<1)nums[i]=-1;
            else if (nums[i]-1==i) continue;
            else {
                int from= i;
                int target=nums[from]-1;
                int value=nums[from];
                int targetV=nums[target];
                while (target!= i) {
                    nums[target]=value;
                    if (targetV>nums.length||targetV<1)break;
                    from=target;
                    target=targetV-1;
                    if (from==target)break;
                    value=targetV;
                    targetV=nums[target];
                }
                if (i==target){
                    nums[i]=value;
                }
                else nums[i]=-1;
            }
        }
        int i;
        for (i = 0; i < nums.length; i++) {
            if (nums[i]==-1) break;
        }
        return i+1;
    }
    public void replace(int[] nums, int index, int value){
        nums[index]=value;
    }

    public static void main(String[] args) {
        System.out.println(new LC41().firstMissingPositive(new int[]{4,2,3,1}));
    }
}
