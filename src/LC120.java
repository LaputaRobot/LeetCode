import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LC120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> record=new ArrayList();
        int min=Integer.MIN_VALUE;
        record.add(triangle.get(0).get(0));
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> rec= new ArrayList<>();
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j==0) rec.add(record.get(0)+triangle.get(i).get(j));
                else if (j==triangle.get(i).size()-1) rec.add(record.get(j-1)+triangle.get(i).get(j));
                else record.add(Math.min(record.get(j),record.get(j-1))+triangle.get(i).get(j));
            }
            record=rec;
        }
        for (int num : record) {
            if (num<min) min=num;
        }
        return min;
    }

    public static void main(String[] args) {
        LC120 lc120=new LC120();
        List<List<Integer>> triangle=new ArrayList<>();
        int[] x1={2};
        int[] x2={3,4};
        int[] x3={6,5,7};
        int[] x4={4,1,8,3};
        List list1=Arrays.stream(x1).boxed().collect(Collectors.toList());;
        triangle.add(list1);
        triangle.add(Arrays.stream(x2).boxed().collect(Collectors.toList()));
        triangle.add(Arrays.stream(x3).boxed().collect(Collectors.toList()));
        triangle.add(Arrays.stream(x4).boxed().collect(Collectors.toList()));
        System.out.println(lc120.minimumTotal(triangle));
    }
}
