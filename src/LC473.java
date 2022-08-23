import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC473 {
    public boolean makesquare(int[] matchsticks) {
        Map<Integer,Integer> map=new HashMap<>();
        int sum=0;
        int max=0;
        for (int matchstick : matchsticks) {
            sum += matchstick;
            if (matchstick > max) max = matchstick;
        }
        int target=sum/4;
        if (sum%4!=0||max>target) return false;
        Arrays.sort(matchsticks);
        int x=0;
        int y=0;
        for (int i=0;i<matchsticks.length;i++ ) {
            if (matchsticks[i] == target) {
                x++;
                continue;
            }
            if (matchsticks[i] != -1) {
                int tmp=matchsticks[i];
                matchsticks[i]=-1;
                boolean b = find(matchsticks, target - tmp, matchsticks.length - 1);
                if (b) {
                    y++;
                }else return false;
            }
        }
        return x+y==4;
    }
    public  boolean find(int[] matchsticks,int target,int end){
        if (target==0)return true;
        while (end>0) {
            for (int i = end; i > 0; i--) {
                if (target >= matchsticks[i] && matchsticks[i] != -1) {
                    int tmp = matchsticks[i];
                    matchsticks[i] = -1;
                    boolean b = find(matchsticks, target - tmp, i);
                    if (!b) {
                        matchsticks[i] = tmp;
                    } else {
                        return true;
                    }
                }
            }
            end--;
        }
        return false;
    }

    public static void main(String[] args) {
        LC473 lc473 = new LC473();
//        int[] matchsticks = {10,6,5,5,5,3,3,3,2,2,2,2};
        int[] matchsticks = {1,1,2,2,2};
        System.out.println(lc473.makesquare(matchsticks));
    }
}

