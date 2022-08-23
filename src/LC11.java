public class LC11 {
    public int maxArea(int[] height) {
        int maxArea=0;
        int left=0,right=height.length-1;
        while (left<right){
            int area=Math.min(height[right],height[left])*(right-left);
            if (area>maxArea) maxArea=area;
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }
    public static void main(String[] args) {
        int[] height={1,2};
        System.out.println(new LC11().maxArea(height));
    }
}
