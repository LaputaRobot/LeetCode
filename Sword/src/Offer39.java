public class Offer39 {
    public int majorityElement(int[] nums) {
        int sum=0,res=-1;
        for (int num : nums) {
            if (sum==0) {
                res = num;
                sum+=1;
            }
            else {
                if (num!=res) sum-=1;
                else sum+=1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Offer39().majorityElement(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
    }
}
