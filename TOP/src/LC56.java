import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(inter1,inter2)->(inter1[0]-inter2[0]));
        int[][] res=new int[intervals.length][2];
        int x=-1;
        for (int[] inter : intervals) {
            if ((x==-1)||(inter[0]>res[x][1])) {
                x++;
                res[x] = inter;
            }
            else res[x]=new int[]{res[x][0],Math.max(res[x][1],inter[1])};
        }
        return Arrays.copyOf(res,x+1);
    }

    public static void main(String[] args) {
        int[][] intervals={{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(new LC56().merge(intervals)));
        List<Integer> l=new ArrayList<>();
        l.add(1);
        l.add(1);
        l.add(1);
        System.out.println(Arrays.toString(l.toArray(new Integer[]{})));
    }
}
