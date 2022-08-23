import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LC139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict=new HashSet<>(wordDict);
        boolean[] dp=new boolean[s.length()+1];
        dp[0]=true;
        for (int i = 0; i < s.length(); i++) {
            if (!dp[i])continue;
            for (int j = i+1; j < s.length()+1; j++) {
                if (dp[i]&&dict.contains(s.substring(i,j))) {
                    dp[j] = true;
                    if (j==s.length()) return true;
                }
            }
        }
        return dp[s.length()];
    }


    public static void main(String[] args) {
//        String s="catsandog";
        String s="catsandog";
        List<String> wordDict=new ArrayList<>();
//        wordDict.add("apple");
//        wordDict.add("pen");
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("an");
        wordDict.add("cat");
        System.out.println(new LC139().wordBreak(s,wordDict));
    }
}
