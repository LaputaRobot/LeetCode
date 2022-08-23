public class Offer11 {
    public int minArray(int[] numbers) {
        if (numbers.length==0) return -1;
        int left=0,right=numbers.length-1;
        while (left<right){
            int mid=left+(right-left)/2;
            if (numbers[left]>numbers[right]){
                if (numbers[mid]>=numbers[left])left=mid+1;
                else right=mid;
            }
            else if (numbers[left]==numbers[right]) left++;
            else break;
        }
        return numbers[left];
    }

    public static void main(String[] args) {
        int[] numbers=new int[]{2,2,2,0,1};
        System.out.println(new Offer11().minArray(numbers));
    }
}
