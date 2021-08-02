import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class LC542 {
    int[] dx={-1,1,0,0};
    int[] dy={0,0,-1,1};

    public int[][] updateMatrix(int[][] mat) {
        int times=0;
        for (int rand = 1; rand < Math.max(mat.length,mat[0].length); rand++) {
            times=0;
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    int xx,yy,flag=0;
                    if (mat[i][j]<rand) continue;
                    for (int k = 0; k < 4; k++) {
                        xx=i+dx[k];
                        yy=j+dy[k];
                        if (xx>=0&&xx<=mat.length-1&&yy>=0&&yy<=mat[0].length-1){
                            if (mat[xx][yy]<rand) flag++;
                        }
                    }
                    if (flag==0) {
                        mat[i][j] = rand + 1;
                        times++;
                    }
                }
            }
            if (times==0) break;
        }
        return mat;
    }

    public int getMin(int[][] mat,int row,int col){
        int min=0;
        if (mat[row][col]==0) return min;
        int rrow,ccol;
        Queue queue=new ArrayDeque();
        queue.add(mat[row][col]);
        while (!queue.isEmpty()){
            for (int i = 0; i < 4; i++) {
                rrow = row + dx[i];
                ccol = col + dy[i];
                if (rrow >= 0 && rrow <= mat.length - 1 && ccol >= 0 && ccol <= mat[0].length - 1 ) {
                    queue.add(mat[rrow][ccol]);
                }
            }
            int num= (int) queue.remove();
            if (num==0)return min+1;
        }

        return min;
    }

    public static void main(String[] args) {
        LC542 lc542=new LC542();
        int[][] mat={{1, 1, 1,1}, {1, 1, 1,0}, {1, 1, 1,1}, {1, 0, 1,1}};
        System.out.println(Arrays.deepToString(lc542.updateMatrix(mat)));
    }
}
