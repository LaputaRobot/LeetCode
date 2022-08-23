class Vector2D {
    int m;
    int n;
    int i;
    int j=-1;
    int[][] vec;
    public Vector2D(int[][] vec) {
        this.vec=vec;
        for (int[] v: vec) {
            m+=v.length;
        }
    }

    public int next() {
        j++;
        while (j>=vec[i].length){
            i++;
            j=0;
        }
        int tmp=vec[i][j];
        n++;
        return tmp;
    }

    public boolean hasNext() {
        return n != m;
    }
}
public class LC251 {
    public static void main(String[] args) {
        int[][] vec=new int[][]{{}};
        Vector2D obj = new Vector2D(vec);
        System.out.println(obj.hasNext());
//        System.out.println(obj.next());
//        System.out.println(obj.next());
//        System.out.println(obj.next());
//        System.out.println(obj.hasNext());
//        System.out.println(obj.hasNext());
//        System.out.println(obj.next());
//        System.out.println(obj.next());
//        System.out.println(obj.hasNext());
    }
}
