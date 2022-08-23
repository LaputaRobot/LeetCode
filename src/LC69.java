public class LC69 {
    public int peakIndexInMountainArray(int[] arr) {
        int left=0,right=arr.length-1;
        int mid=left+(right-left)/2;
        while (true){
            if (mid==0) return arr[mid]>arr[mid+1]?mid:mid+1;
            if (mid==arr.length-1) return arr[mid]>arr[mid-1]?mid:mid-1;
            if (arr[mid]>arr[mid-1]&&arr[mid]>arr[mid+1]) break;
            else if (arr[mid]>arr[mid-1]&&arr[mid]<arr[mid+1]) left=mid+1;
            else if (arr[mid]<arr[mid-1]&&arr[mid]>arr[mid+1]) right=mid-1;
            mid=left+(right-left)/2;
        }
        return mid;
    }

    public static void main(String[] args) {
        int[] arr={0,2,1,0};
        System.out.println(new LC69().peakIndexInMountainArray(arr));
    }
}
