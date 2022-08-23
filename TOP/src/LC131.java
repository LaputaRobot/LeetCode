import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC131 {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        boolean[][] dp=new boolean[s.length()][s.length()];
//        for (int len = 0; len < s.length(); len++) {
//            for (int i = 0; i+len < s.length(); i++) {
//                int j=i+len;
//                if (j==i)dp[i][j]=true;
//                else {
//                    boolean b = s.charAt(i) == s.charAt(j);
//                    if (i+1>j-1) dp[i][j]= b;
//                    else {
//                        dp[i][j]= b &&dp[i+1][j-1];
//                    }
//                }
//            }
//        }
        for (int i = 0; i < s.length(); ++i) {
            Arrays.fill(dp[i], true);
        }

        for (int i = s.length()-1 - 1; i >= 0; --i) {
            for (int j = i + 1; j < s.length(); ++j) {
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1];
            }
        }
        LinkedList<String> tmp=new LinkedList<>();
        helper(s,res,dp,0,tmp);
        return res;
    }
    public void helper(String s, List<List<String>> res, boolean[][] dp, int i, LinkedList<String> tmp){
        if (i>s.length()-1) {
            res.add((List<String>) tmp.clone());
            return;
        }
        for (int j = i; j < s.length(); j++) {
            if (dp[i][j]){
                tmp.add(s.substring(i,j+1));
                helper(s,res,dp,j+1,tmp);
                tmp.removeLast();
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(new LC131().partition("ababab"));
    }
}
