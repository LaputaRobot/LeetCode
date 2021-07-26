import java.util.HashMap;

public class LC567 {
    public static boolean checkInclusion(String s1, String s2) {
        boolean ans=false;
        int left=0,right=0;
        HashMap hashMap=new HashMap();
        for (Character c :
                s1.toCharArray()) {
            if (hashMap.containsKey(c)) hashMap.put(c,(int)hashMap.get(c)+1);
            else hashMap.put(c,1);
        }
        HashMap hashMap1= (HashMap) hashMap.clone();
        for (;right<s2.length();right++){
            Character c=s2.charAt(right);
            if (!hashMap1.containsKey(c)){
                left=right+1;
                hashMap1= (HashMap) hashMap.clone();
            }
            else {
                hashMap1.put(c, (int)hashMap1.get(c)-1);
                while ((int)hashMap1.get(c)<0) {
                    hashMap1.put(s2.charAt(left), (int)hashMap1.get(s2.charAt(left))+1);
                    left ++;
                }
            }
            if (right-left+1==s1.length()) {
                return true;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String s1="adc",s2="dcdda";
        System.out.println(checkInclusion(s1,s2));
    }
}
