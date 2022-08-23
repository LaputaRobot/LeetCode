package wangyi0421;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Lujin {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String[] line1=scanner.nextLine().split(" ");
        int n=Integer.parseInt(line1[0]);
        int m=Integer.parseInt(line1[1]);
        int[][] matrix=new int[n+1][n+1];
        for (int i = 0; i < m; i++) {
            String[] line=scanner.nextLine().split(" ");
            int x=Integer.parseInt(line[0]);
            int y=Integer.parseInt(line[1]);
            int w=Integer.parseInt(line[2]);
            matrix[x][y]=w;
//            matrix[y][x]=w;
        }
        Deque<Integer> deque=new ArrayDeque<>();
        int[] res=new int[n+1];
        boolean[] flag=new boolean[n+1];
        Arrays.fill(res,Integer.MAX_VALUE);
        res[1]=0;
        deque.add(1);
        while (!deque.isEmpty()){
            int src=deque.poll();
            flag[src]=true;
            for (int i = 1; i <=n; i++) {
                if (matrix[src][i]!=0&&!flag[i]){
                    deque.add(i);
                    if (res[src]+matrix[src][i]<res[i]){
                        res[i]=res[src]+matrix[src][i];
                    }
                }
            }
        }
        System.out.println(res[n]==Integer.MAX_VALUE?-1:res[n]);
    }
}
