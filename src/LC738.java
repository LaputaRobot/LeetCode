public class LC738 {
    public int monotoneIncreasingDigits(int n) {
        char[] res=String.valueOf(n).toCharArray();
        int len=res.length;
        for (int i = len-1; i > 0; i--) {
            if (res[i]>=res[i-1]){
                res[i-1]=res[i-1];
            }else {
                res[i]='9';
                res[i-1]= (char) (res[i-1]-1);
                int j=i+1;
                while (j<len&&res[j]<res[j-1]) {
                    res[j] = '9';
                    j++;
                }
            }
        }
        return Integer.parseInt(new String(res));
    }
    public static void main(String[] args) {
        System.out.println(new LC738().monotoneIncreasingDigits(789123));
    }
}
