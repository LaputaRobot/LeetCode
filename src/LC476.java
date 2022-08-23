public class LC476 {
    public int findComplement(int num) {
        int x=1;
        while (x<num){
            x<<=1;
            x+=1;
        }
        return (~num)&x;
    }
    public static void main(String[] args) {
        System.out.println(new LC476().findComplement(5));
    }
}
