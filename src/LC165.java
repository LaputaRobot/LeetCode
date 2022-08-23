public class LC165 {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int len=Math.max(v1.length,v2.length);
        for (int i = 0; i < len; i++) {
            int x=i<v1.length?Integer.parseInt(v1[i]):0;
            int y=i<v2.length?Integer.parseInt(v2[i]):0;
            if (x>y){
                return 1;
            }else if (x<y) return -1;
        }
        return 0;
    }

    public int compareVersion1(String version1, String version2) {
        int s1=0;
        int s2=0;
        while (s1<version1.length()||s2<version2.length()){
            int[] ints1 = parseSubVersion(version1, s1);
            s1=ints1[1];
            int[] ints2 = parseSubVersion(version2, s2);
            s2=ints2[1];
            if (ints1[0]>ints2[0]) return 1;
            else if (ints1[0]<ints2[0]) return -1;
        }
        return 0;
    }

    public int[] parseSubVersion(String version,int start){
        if (start>=version.length())return new int[]{0,start};
        if (version.charAt(start)=='.') start++;
        int end=start;
        while (end<version.length()&&version.charAt(end)!='.') end++;
        return new int[]{ Integer.parseInt(version.substring(start,end)),end};
    }

    public static void main(String[] args) {
        LC165 lc165 = new LC165();
        String version1="1.001";
        String version2="1.01";
        System.out.println(lc165.compareVersion1(version1, version2));
    }
}
