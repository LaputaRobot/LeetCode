public class LC2105 {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int len=plants.length;
        int aSum=0;
        int bSum=0;
        int shyA=capacityA;
        int shyB=capacityB;
        for (int i = 0; i < len/2; i++) {
            if (plants[i]>shyA){
                shyA=capacityA;
                aSum++;
            }
            shyA-=plants[i];
        }
        for (int i = len-1; i >len/2; i--) {
            if (plants[i]>shyB){
                shyB=capacityB;
                bSum++;
            }
            shyB-=plants[i];
        }
        if (len%2==0){
            return aSum+bSum+(shyB>=plants[len/2]?0:1);
        }
        else return aSum+bSum+(Math.max(shyA,shyB)>=plants[len/2]?0:1);
    }

    public static void main(String[] args) {
        int[] plants=new int[]{1,2};
        int capacityA=2;
        int capacityB=2;
        LC2105 lc2105 = new LC2105();
        System.out.println(lc2105.minimumRefill(plants,capacityA,capacityB));
    }
}
