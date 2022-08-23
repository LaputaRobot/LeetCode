public class LC28 {
    public int strStr(String haystack, String needle) {
        if (needle.length()==0) return 0;
        int start=0;
        int i=0,j=0;
        while (start+needle.length()<=haystack.length()){
            if (haystack.charAt(start+i)==needle.charAt(j)){
                i++;
                j++;
                if (j==needle.length()) return start;
            }
            else {
                start++;
                i=0;
                j=0;
            }
        }
        return -1;
    }
    public int strStr1(String haystack, String needle) {
        int n=haystack.length(), m=needle.length();
        if(m==0) return 0;
        // 先构造next数组，next数组中的元素表示当前两个元素不匹配时，needle指针要跳转的位置
        // haystack: [a, b, e, a, b, a, b, e, a, b, f]
        // needle:   [a, b, e, a, b, f]
        // next:     [0, 0, 0, 1, 2, 0]
        int[] next = new int[m];
        for(int i=1,j=0; i<m; i++){
            while(j>0 && needle.charAt(i)!=needle.charAt(j))
                j = next[j-1]; // 一直和前一位置的值比较，直到遇到相等的字符或者j=0；j通过next[j-1]来回退
            if(needle.charAt(i)==needle.charAt(j)) j++;
            next[i] = j;
        }
        // 利用next数组进行跳转匹配，不再需要回退haystack的指针i
        for(int i=0,j=0; i<n; i++){
            // 匹配不成功，needle指针j回退并继续比较
            while(j>0 && haystack.charAt(i)!=needle.charAt(j))
                j = next[j-1];
            if(haystack.charAt(i)==needle.charAt(j)) j++;
            if(j==m) return i - m + 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        String haystack = "aabaafaa", needle = "aafaa";
        System.out.println(new LC28().strStr1(haystack,needle));
        System.out.println(haystack.indexOf(needle));
    }
}
