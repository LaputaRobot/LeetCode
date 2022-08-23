public class LC434 {
    public int countSegments(String s) {
        int result=0;
        int flag=0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)!=' '){
                flag=1;
                if (i==s.length()-1) result++;
            }
            else if (flag==1) {
                flag=0;
                result++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String s="   Of all the gin    joints in all the towns in all the world,   ";
        System.out.println(new LC434().countSegments(s));
    }
}
