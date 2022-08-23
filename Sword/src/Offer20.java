public class Offer20 {
    public boolean isNumber(String s) {
        s=s.trim();
        if (s.length()==0) return false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='e'||s.charAt(i)=='E'){
                return i>0&&(s.charAt(i-1)!='+'&&s.charAt(i-1)!='-')&&isAllNumE(s,i+1,true);
            }
            else if (s.charAt(i)=='.'){
                return isAllNumP(s,i+1,true);
            }
            else if ((s.charAt(i)=='+'||s.charAt(i)=='-')){
                if (i>0) return false;
            }
            else if (s.charAt(i)<'0'||s.charAt(i)>'9')  return false;
        }
        return true;
    }
    public boolean isAllNumE(String s,int start,boolean isE){
        if (start==s.length()) return false;
        for (int i = start; i < s.length(); i++) {
            if (isE&&(s.charAt(i)=='+'||s.charAt(i)=='-')){
                isE=false;
                if (i==s.length()-1)return false;
            }
            else if(s.charAt(i)<'0'||s.charAt(i)>'9'){
                return false;
            }
        }
        return true;
    }
    public boolean isAllNumP(String s,int start,boolean isP){
        if (start==1&&start==s.length()) return false;
        for (int i = start; i < s.length(); i++) {
            if (isP&&(s.charAt(i)=='e'||s.charAt(i)=='E')&&i>1){
                return isAllNumE(s,i+1,true);
            }
            else if(s.charAt(i)<'0'||s.charAt(i)>'9'){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] strs={"0.e+1.e+2"};
        for (String s : strs) {
            System.out.println(s);
            System.out.println(new Offer20().isNumber(s));
        }
    }
}
