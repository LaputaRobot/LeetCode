public class LC990 {
    public boolean equationsPossible(String[] equations) {
        UnionFind unionFind= new UnionFind(26);
        for (String equation : equations) {
            char[] chars = equation.toCharArray();
            if (chars[1] == '=') {
                unionFind.union(chars[0] - 'a', chars[3] - 'a');
            }
        }
        for (String equation : equations) {
            char[] chars = equation.toCharArray();
            if (chars[1] == '!') {
                if (unionFind.isUnion(chars[0] - 'a', chars[3] - 'a'))
                    return false;
            }
        }
        return true;
    }


    static class UnionFind{
        int[] parent;
        public UnionFind(int len) {
            parent=new int[len];
            for (int i = 0; i < len; i++) {
                parent[i]=i;
            }
        }
        public void union(int index1,int index2){
            parent[findParent(index1)]=findParent(index2);
        }
        public boolean isUnion(int index1,int index2){
            return findParent(index1) == findParent(index2);
        }
        private int findParent(int index){
            while (index!=parent[index]){
                parent[index]=parent[parent[index]];
                index=parent[index];
            }
            return index;
        }
    }
    public static void main(String[] args) {
        String[] equations=new String[]{"f==a","a==b","f!=e","a==c","b==e","c==f"};
        System.out.println(new LC990().equationsPossible(equations));
    }
}
