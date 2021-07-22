public class LC557 {
    // 可优化，时间空间复杂度都较高
    public static String reverseWords(String s) {
        int left=0,right=0,lastR=0;
        String resultS="";
        while (left<=s.length()-1){
            do{
                right++;
                if (right==s.length())
                    break;
            }
            while (s.charAt(right)!=' ');
            right=right-1;
            lastR=right;
            while (left<=right){
                resultS+=s.charAt(right);
                right--;
            }
            left=right=lastR+2;
            if (left<=s.length()-1)
                resultS+=' ';
        }
        return resultS;
    }

    public static void main(String[] args) {
        String s="h a";
        System.out.println(reverseWords(s));
    }
}
