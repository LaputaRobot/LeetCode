import java.util.Arrays;
// 是深度遍历的思路，代码可优化
public class LC733 {
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor,char lastD) {
        int oldColor = image[sr][sc];
        image[sr][sc]=newColor;
        if (lastD!='d'&&fullLen(sr-1,sc,image.length,image[0].length)&&image[sr - 1][sc] == oldColor) floodFill(image, sr - 1, sc, newColor,'u');
        if (lastD!='u'&&fullLen(sr+1,sc,image.length,image[0].length)&&image[sr + 1][sc] == oldColor) floodFill(image, sr + 1, sc, newColor,'d');
        if (lastD!='r'&&fullLen(sr,sc-1,image.length,image[0].length)&&image[sr][sc - 1] == oldColor) floodFill(image, sr, sc - 1, newColor,'l');
        if (lastD!='l'&&fullLen(sr,sc+1,image.length,image[0].length)&&image[sr][sc + 1] == oldColor) floodFill(image, sr, sc + 1, newColor,'r');
        return image;
    }
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
      char lastD='a';
      if (image[sr][sc]==newColor) return image;
      return floodFill(image,sr,sc,newColor,lastD);
    }
    public static boolean fullLen(int a,int b,int len1,int len2){
        return 0<=a&&a<=len1-1&&0<=b&&b<=len2-1;
    }
    public static void main(String[] args) {
        int[][] image=new int[][]{{0,1,1}, {0,1,1}};
        int sr=1,sc=1,newColor=1;
        image=floodFill(image,sr,sc,newColor);
        System.out.println(Arrays.deepToString(image));
    }
}
