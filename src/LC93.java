import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC93 {
    public static void main(String[] args) {
        System.out.println(new LC93().restoreIpAddresses("172162541"));
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        LinkedList<String> tmp = new LinkedList<>();
        dfs(s, 0, res, tmp, 4);
        return res;
    }

    public void dfs(String s, int start, List<String> res, LinkedList<String> tmp, int target) {
        if (target == 0) {
            if (start == s.length()) {
                StringBuilder stringBuilder = new StringBuilder();
                int i = 0;
                for (String str : tmp) {
                    stringBuilder.append(str);
                    if (i++ < 3)
                        stringBuilder.append(".");
                }
                res.add(stringBuilder.toString());
            }
            return;
        }
        for (int j = 0; j < 3; j++) {
            if (start + j < s.length() && isIp(s, start, start + j)) {
                tmp.add(s.substring(start, start + j + 1));
                dfs(s, start + j + 1, res, tmp, target - 1);
                tmp.removeLast();
            }
        }
    }

    public boolean isIp(String s, int start, int end) {
        if (end == start) {
            return true;
        }
        if (start + 1 == end) {
            return s.charAt(start) != '0';
        }
        if (end > start + 2) return false;
        if (s.charAt(start) == '1') {
            return true;
        } else if (s.charAt(start) == '2') {
            if (s.charAt(start + 1) > '5') return false;
            else if (s.charAt(start+1)<'5') return true;
            else {
                return s.charAt(start + 2) <= '5';
            }
        }
        return false;
    }
}
