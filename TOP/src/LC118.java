import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> level=new ArrayList<>();
        level.add(1);
        res.add(level);
        if (numRows==1) {
            return res;
        }
        List<Integer> oLevel=level;
        for (int i = 2; i <= numRows; i++) {
            List<Integer> nLevel=new ArrayList<>();
            nLevel.add(1);
            for (int j = 0; j < oLevel.size()-1; j++) {
                nLevel.add(oLevel.get(j)+oLevel.get(j+1));
            }
            nLevel.add(1);
            res.add(nLevel);
            oLevel=nLevel;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LC118().generate(1));
    }
}
