import java.util.ArrayList;

public class lc5 {
    public static String longestPalindrome(String s) {
        int length=s.length();
        int left=0,right=0;
        int maxLen=0;
        int[][] R=new int[length][length];
        for (int i = 0; i < s.length(); i++) {
            R[i][i]=1;
        }
        R[length-1][length-1]=1;
        for (int i = length-2; i >=0 ; i--) {
            for (int j = i+1; j < length; j++) {
                if (s.charAt(i)==s.charAt(j)&&(R[i+1][j-1]==1||(i+1==j))){
                    R[i][j]=1;
                    if (j-i>maxLen){
                        maxLen=j-i;
                        left=i;
                        right=j;
                    }
                }

            }
        }
        return s.substring(left,right+1);
    }

    public static void main(String[] args) {
        String s="b";
        System.out.println(longestPalindrome(s));
    }
}
