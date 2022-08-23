package jindong;

import java.util.Scanner;
import java.util.Stack;

public class KL {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int T =Integer.parseInt(scanner.nextLine());
        boolean[] ress=new boolean[T];
        for (int i = 0; i < T; i++) {
            int n=Integer.parseInt(scanner.nextLine());
            Stack<String> stack=new Stack<>();
            boolean f=false;
            for (int j = 0; j < n; j++) {
                String str=scanner.nextLine();
                if (f)continue;
                if (!isC(str)) {
                    stack.push(str);
                    f=true;
                }
                if (stack.isEmpty()) stack.push(str);
                else {
                    if (str.startsWith("end ")){
                        String[] p = str.split(" ");
                        if (p.length == 2 && stack.peek().equals(p[1])) {
                            stack.pop();
                        }
                    }
                }
            }
            ress[i]=stack.isEmpty();
        }
        for (int i = 0; i < T; i++) {
            if (ress[i])
                System.out.println("Yes");
            else System.out.println("No");
        }
    }
    public static boolean isC(String str){
        String[] strings=str.split(" ");
        if (strings.length==1){
            if (strings[0].length()>100)return false;
            for (int i = 0; i < strings[0].length(); i++) {
                if (strings[0].charAt(i)<'a'||strings[0].charAt(i)>'z')return false;
            }
            return true;
        }
        else if (strings.length==2){
            if (!strings[0].equals("end"))return false;
            else return isC(strings[1]);
        }
        return false;
    }
}
