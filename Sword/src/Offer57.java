import java.util.*;

public class Offer57 {
    public int[] twoSum(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while (left<right) {
            while (nums[left]+nums[right]>target) right--;
            while (nums[left]+nums[right]<target) left++;
            if (nums[left]+nums[right]==target) {
                int[] res =new int[2];
                res[0]=nums[left];
                res[1]=nums[right];
                return res;
            }
        }
        return new int[]{};
    }

    public int[][] findContinuousSequence(int target) {
        if (target<=2) return new int[][]{};
        ArrayList<LinkedList<Integer>> res=new ArrayList<>();
        LinkedList<Integer> tmp=new LinkedList<>();
        int sum=0;
        for (int i = 1; i <= target/2+1; i++) {
                sum+=i;
                tmp.add(i);
            while (sum>target){
                sum-=tmp.poll();
            }
            if (target==sum)
                res.add((LinkedList<Integer>) tmp.clone());
        }
        int[][] intRes=new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            intRes[i]= res.get(i).stream().mapToInt(Integer::intValue).toArray();
        }
        return intRes;
    }
    public static void main(String[] args) {
//        int[ ] nums =new int[]{10,26,30,31,47,60};
//        System.out.println(Arrays.toString(new Offer57().twoSum(nums, 70)));
        System.out.println(Arrays.deepToString(new Offer57().findContinuousSequence(1010)));
    }
}
