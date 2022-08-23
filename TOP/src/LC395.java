import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class LC395 {
    public int longestSubstring(String s, int k) {
        int left = 0;
        int right = 0;
        int res = 0;
        int[] times = new int[26];
        int[] used = new int[26];
        for (int i = 0; i < s.length(); i++) {
            times[s.charAt(i) - 'a'] += 1;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            times[index] -= 1;
            used[index] += 1;
            if (times[index] + used[index] >= k) {
                right=i;
                if (used[index] < k) set.add(index);
                if (used[index] >= k) set.remove(index);
            } else {
                right = i-1;
                if (left<right) {
                    int leftIndex = s.charAt(left) - 'a';
                    while (set.contains(leftIndex)) {
                        left++;
                        used[leftIndex]--;
                        if (used[leftIndex] == 0) set.remove(leftIndex);
                        leftIndex = s.charAt(left) - 'a';
                    }
                    int rightIndex = s.charAt(right) - 'a';
                    while (set.contains(rightIndex)) {
                        right--;
                        used[rightIndex]--;
                        if (used[rightIndex] == 0) set.remove(rightIndex);
                        rightIndex = s.charAt(right) - 'a';
                    }
                    if (set.isEmpty()) res = Math.max(res, right - left + 1);
                    else res = Math.max(res, longestSubstring(s.substring(left, right+1), k));
                }
                left=i+1;
                Arrays.fill(used,0);
            }
        }
        if (left<=right) res = Math.max(res, right - left+1);
        return res;
    }

    public int longestSubstring1(String s, int k) {
        int ans = 0;
        int n = s.length();
        char[] cs = s.toCharArray();
        int[] cnt = new int[26];
        for (int p = 1; p <= 26; p++) {
            Arrays.fill(cnt, 0);
            // tot 代表 [j, i] 区间所有的字符种类数量；sum 代表满足「出现次数不少于 k」的字符种类数量
            for (int i = 0, j = 0, tot = 0, sum = 0; i < n; i++) {
                int u = cs[i] - 'a';
                cnt[u]++;
                // 如果添加到 cnt 之后为 1，说明字符总数 +1
                if (cnt[u] == 1) tot++;
                // 如果添加到 cnt 之后等于 k，说明该字符从不达标变为达标，达标数量 + 1
                if (cnt[u] == k) sum++;
                // 当区间所包含的字符种类数量 tot 超过了当前限定的数量 p，那么我们要删除掉一些字母，即「左指针」右移
                while (tot > p) {
                    int t = cs[j++] - 'a';
                    cnt[t]--;
                    // 如果添加到 cnt 之后为 0，说明字符总数-1
                    if (cnt[t] == 0) tot--;
                    // 如果添加到 cnt 之后等于 k - 1，说明该字符从达标变为不达标，达标数量 - 1
                    if (cnt[t] == k - 1) sum--;
                }
                // 当所有字符都符合要求，更新答案
                if (tot == sum) ans = Math.max(ans, i - j + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LC395().longestSubstring("aacbbbdc" ,3));
    }
}
