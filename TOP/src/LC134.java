public class LC134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int res=0;
        int sum=0;
        int tmp;
        int oldSum=0;
        for (int i = 0; i < gas.length; i++) {
            tmp=gas[i]-cost[i];
            sum+=tmp;
            if (sum<0){
                oldSum+=sum;
                if (i==gas.length-1) return -1;
                sum=0;
                res=i+1;
            }
        }
        return oldSum+sum<0?-1:res;
    }

    public static void main(String[] args) {
        int[] gas={4,4,4,1}; int[] cost={8,1,1,3};
        System.out.println(new LC134().canCompleteCircuit(gas,cost));
    }
}
