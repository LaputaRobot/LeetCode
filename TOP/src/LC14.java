public class LC14 {
    public String longestCommonPrefix(String[] strs) {
        int shortestL=201;
        for (String str : strs) {
            if (shortestL > str.length()) shortestL = str.length();
        }
        if (shortestL==0) return "";
        StringBuilder res= new StringBuilder();
        for (int i = 0; i < shortestL; i++) {
            char ch=strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (ch!=strs[j].charAt(i)) return res.toString();
            }
            res.append(ch);
        }
        return res.toString();
    }

    //空间复杂度可以更低,（好像并没有降低
    public String longestCommonPrefix1(String[] strs) {
        String res= strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j=0;
            while (j<res.length()&&j<strs[i].length()){
                if (res.charAt(j)!=strs[i].charAt(j))break;
                j++;
            }
            res=res.substring(0,j);
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs={"flower","flow","flight"};
        System.out.println(new LC14().longestCommonPrefix1(strs));
    }

}
