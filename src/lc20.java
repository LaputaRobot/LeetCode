public class lc20 {
    public static boolean isValid(String s) {
        boolean is = false;
        char[] stack = new char[s.length()];
        int stackIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            stack[stackIndex] = s.charAt(i);
            if(stackIndex>=1){
            while ((stack[stackIndex] == ')' && stack[stackIndex - 1] == '(') ||
                    (stack[stackIndex] == ']' && stack[stackIndex - 1] == '[') ||
                    (stack[stackIndex] == '}' && stack[stackIndex - 1] == '{')
            ) {
                stackIndex=stackIndex-2;
                if(stackIndex<1) break;
            }}
            stackIndex++;
        }
        if (stackIndex == 0) is = true;
        return is;
    }

    public static void main(String[] args) {
        String s = "()]";
        System.out.println(isValid(s));
    }
}
