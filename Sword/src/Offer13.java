public class Offer13 {
    public int movingCount(int m, int n, int k) {
        boolean[][] record=new boolean[m][n];
        return bfs(0,0,k,record);
    }
    public int bfs(int i,int j,int k,boolean[][] record){
       if (i<0||j<0||i>=record.length||j>=record[0].length) return 0;
       if (record[i][j]) return 0;
       if (isBigger(i,j,k)) {
           record[i][j] = true;
           return 0;
       }
       record[i][j]=true;
       return bfs(i+1,j,k,record)+bfs(i,j+1,k,record)+1;
    }
    public boolean isBigger(int i,int j,int k){
        int res=0;
        while (i>0) {
            res+=(i%10);
            i=i/10;
        }
        while (j>0) {
            res+=(j%10);
            j=j/10;
        }
        return res>k;
    }
    public static void main(String[] args) {
        System.out.println(new Offer13().movingCount(31,13,10));
    }
}
