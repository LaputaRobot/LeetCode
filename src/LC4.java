import java.util.Arrays;

public class LC4 {
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays1(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int left = 0, right = m;
        // median1：前一部分的最大值
        // median2：后一部分的最小值
        int median1 = 0, median2 = 0;

        while (left <= right) {
            // 前一部分包含 nums1[0 .. i-1] 和 nums2[0 .. j-1]
            // 后一部分包含 nums1[i .. m-1] 和 nums2[j .. n-1]
            int i = (left + right) / 2;
            int j = (m + n + 1) / 2 - i;

            // nums_im1, nums_i, nums_jm1, nums_j 分别表示 nums1[i-1], nums1[i], nums2[j-1], nums2[j]
            int nums_im1 = (i == 0 ? Integer.MIN_VALUE : nums1[i - 1]);
            int nums_i = (i == m ? Integer.MAX_VALUE : nums1[i]);
            int nums_jm1 = (j == 0 ? Integer.MIN_VALUE : nums2[j - 1]);
            int nums_j = (j == n ? Integer.MAX_VALUE : nums2[j]);

            if (nums_im1 <= nums_j) {
                median1 = Math.max(nums_im1, nums_jm1);
                median2 = Math.min(nums_i, nums_j);
                left = i + 1;
            } else {
                right = i - 1;
            }
        }

        return (m + n) % 2 == 0 ? (median1 + median2) / 2.0 : median1;
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m=nums1.length,n=nums2.length;
        System.out.println("m: "+m+", n: "+n);
        int midSum=0;
        int left1=0,left2=0;
        int right1=m-1,right2=n-1;
        int mid1=0,mid2=0;
        int flag=0;
        while (midSum<(m+n)/2){
            mid1=(left1+right1)/2;
            mid2=(left2+right2)/2;
            if (nums1[mid1]>nums2[mid2]){
                if (left2==mid2){
                    midSum+=(mid2-left2+1);
                    left2=mid2+1;
                }
                else {
                    midSum+=(mid2-left2);
                    left2=mid2;
                }

                right1=mid1;
            }
            if (nums1[mid1]<=nums2[mid2]){
                if (left1==mid1){
                    midSum+=(mid1-left1+1);
                    left1=mid1+1;
                }
                else {
                    midSum+=(mid1-left1);
                    left1=mid1;
                }
                right2=mid2;
            }
            if (left1==right1) flag=1;
            if (left2==right2) {
                if (flag==1) {
                    flag=0;
                    break;
                }
                flag = 2;
            }
        }
        System.out.println(""+left1+", "+right1);
        System.out.println(""+left2+", "+right2);
        System.out.println(""+flag);
        System.out.println(midSum);
        if ((m+n)%2!=0){
            if (right1==m-1){
                return nums2[right2];
            }
            else if (right2==n-1){
                return nums1[right1];
            }
            else {
                if (midSum==(m+n)/2)
                return Math.min(nums1[left1], nums2[left2]);
                else return Math.max(nums1[left1], nums2[left2]);
            }
        }
        else {
            if (flag==1){
                return (nums2[left2]+nums2[left2-1])/2.0;
            }
            else if (flag==2){
                return (nums1[left1]+nums1[left1-1])/2.0;
            }
            else {
                if (midSum==(m+n)/2)
                return nums1[right1]<nums2[right2]?(nums1[right1]+nums1[right1-1])/2.0:(nums2[right2]+nums2[right2-1])/2.0;
                else return (nums1[right1]+nums2[right2])/2.0;
            }
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length,n=nums2.length;
        int targetIndex=0;
        if ((m+n)%2==0)targetIndex=(m+n)/2;
        else targetIndex=(m+n)/2-1;
        int left1=0,right1=nums1.length-1;
        int left2=0,right2=nums2.length-1;
        int currentLen=0;
        int mid1=0,mid2=0;
        while (currentLen<targetIndex){
            mid1=(left1+right1)/2;
            mid2=(left2+right2)/2;
            if (nums1[right1]<nums2[left2]){

            }
            else if (nums2[right2]<nums1[left1]){

            }
            else {
                if (nums1[mid1] < nums2[mid2]) {
                    currentLen += (mid1 - left1);
                    left1 = mid1;
                } else if (nums1[mid1] > nums2[mid2]) {
                    currentLen += (mid2 - left2);
                    left2 = mid2;
                } else {
                    currentLen += (mid1 - left1 + mid2 - left2);
                    left1 = mid1;
                    left2 = mid2;
                }
            }
        }
        if ((m+n)%2==0) return Math.min(nums1[mid1],nums2[mid2]);
        else return (nums1[mid1]+nums2[mid2])/2;
    }
    public static void main(String[] args) {
        int m= (int) (Math.random()*5+5);
        int n=(int) (Math.random()*5+5);
        int[]  nums1=new int[m];
        int[] nums2=new int[n];
        for (int i = 0; i < nums1.length; i++) {
            nums1[i]=(int) (Math.random()*80+40);
        }
        for (int i = 0; i < nums2.length; i++) {
            nums2[i]=(int) (Math.random()*80);
        }
        nums1=new int[]{40, 63, 67, 78, 83, 114, 118};
        nums2=new int[]{6, 17, 26, 48, 59, 60};
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        LC4 lc4=new LC4();
        System.out.println(lc4.findMedianSortedArrays(nums1,nums2));
    }
}
