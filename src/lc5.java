import java.util.ArrayList;

public class lc5 {
    public static String longestPalindrome(String s) {
        boolean[][] dp=new boolean[s.length()][s.length()];
        int maxLen=1;
        for (int i = 0; i <s.length(); i++) {
           dp[i][i]= true;
        }
        for (int L = 2; L <= s.length(); L++) {
            for (int i = 0; i < s.length(); i++) {
                int j=i+L-1;

            }
        }

        return s;
    }

    public static void main(String[] args) {

    }
}
