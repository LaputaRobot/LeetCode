import java.util.*;

public class LC406 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new LC406().reconstructQueue1(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}})));
    }
    public int[][] reconstructQueue(int[][] people) {
        ArrayList<int[]> res=new ArrayList<>();
        Arrays.sort(people,(o1, o2) -> o1[1]==o2[1]?o2[0]-o1[0]:o1[1]-o2[1]);
        for (int[] p : people) {
            int t=p[1];
            int index=0;
            for (int[] r : res) {
                if (t==0)break;
                if(r[0]>=p[0]) {
                    t--;
                }
                index++;
            }
            res.add(index,p);
        }
        return res.toArray(new int[0][]);
    }
    public int[][] reconstructQueue1(int[][] people) {
        Arrays.sort(people, (person1, person2) -> {
            if (person1[0] != person2[0]) {
                return person2[0] - person1[0];
            } else {
                return person1[1] - person2[1];
            }
        });
        List<int[]> ans = new ArrayList<>();
        for (int[] person : people) {
            ans.add(person[1], person);
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
