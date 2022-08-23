public class LC38 {
    public String countAndSay(int n) {
        String res="1";
        for (int i = 2; i <= n; i++) {
            res=getNext(res);
        }
        return res;
    }
    public String getNext(String str){
        StringBuilder newStr=new StringBuilder();
        int num=1;
        int i;
        boolean checkLast=false;
        for (i = 0; i < str.length()-1; i++) {
            if (str.charAt(i)==str.charAt(i+1)){
                num++;
                if (i==str.length()-2) checkLast=true;
            }
            else {
                newStr.append(""+num+str.charAt(i));
                num=1;
            }
        }
        if (!checkLast) newStr.append("1"+str.charAt(str.length()-1));
        else  newStr.append(""+num+str.charAt(i));
        return newStr.toString();
    }
    public static void main(String[] args) {
        System.out.println(new LC38().countAndSay(2));
    }
}
