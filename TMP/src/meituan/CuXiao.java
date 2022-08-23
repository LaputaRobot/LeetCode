package meituan;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class CuXiao {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String nm=scanner.nextLine();
        int n=Integer.parseInt(nm.split(" ")[0]);
        int m=Integer.parseInt(nm.split(" ")[1]);
        int[][] range=new int[m][2];
        String[] ls=scanner.nextLine().split(" ");
        String[] rs=scanner.nextLine().split(" ");
        for (int i = 0; i < m; i++) {
            range[i][0]=Integer.parseInt(ls[i]);
            range[i][1]=Integer.parseInt(rs[i]);
        }
        Arrays.sort(range, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
               return o1[0]==o2[0]?o1[1]-o2[1]:o1[0]-o2[0];
            }
        });
        System.out.println(Arrays.deepToString(range));
        int res=0;
        int left=range[0][0],right=range[0][1];
        for (int i = 1; i < range.length; i++) {
            if (range[i][1]<left)continue;
            if(range[i][0]<left)
                range[i][0]=left;
            if (range[i][0]==left) {
                if (range[i][1] > right) {
                    res += (right - left + 1);
                    left = right+1;
                    right = range[i][1];
                } else{
                    res += (range[i][1] - range[i][0] + 1);
                    left = range[i][1]+1;
                }
            }
            else {
                if (range[i][1] > right) {
                    res += (right - range[i][0] + 1);
                    left = right+1;
                    right = range[i][1];
                } else{
                    res += (range[i][1] - range[i][0] + 1);
                    left = range[i][1]+1;
                }
            }
        }
        System.out.println(res);
    }
}
