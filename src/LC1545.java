public class LC1545 {
    public char findKthBit(int n, int k) {
        int[] lens=new int[n+1];
        for (int i=1;i<=n;i++){
            lens[i]=2*lens[i-1]+1;
        }
        boolean flag=true;
        while (k>1){
            int l=indexLen(lens,k);
            if (l+1==k)return '1';
            k=2*(l+1)-k;
            flag=!flag;
        }
        return flag?'0':'1';
    }

    public int indexLen(int[] lens,int k){
        for (int i=lens.length-1;i>=0;i--) {
            if (k>lens[i]) return lens[i];
        }
        return lens[0];
    }

    public static void main(String[] args) {
        LC1545 lc1545 = new LC1545();
        System.out.println(lc1545.findKthBit(4, 12));
    }
}
