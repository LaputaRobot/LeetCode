public class LC171 {
    public int titleToNumber(String columnTitle) {
        int res=0;
        for (int i = 0; i < columnTitle.length(); i++) {
            char ch=columnTitle.charAt(columnTitle.length()-1-i);
            res+=(ch-'A'+1)*Math.pow(26,i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LC171().titleToNumber("ZY"));
    }
}
