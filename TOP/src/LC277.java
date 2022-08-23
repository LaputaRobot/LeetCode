import javax.management.relation.Relation;

class Solution {
    public int findCelebrity(int n,int[][] relations) {
        int ans = 0;
        for(int k = 0; k < n; k++){
            if(knows(ans, k,relations)){
                ans = k;
            }
        }

        for(int k = 0; k < n; k++){
            if(k != ans){
                if(!knows(k, ans,relations)){
                    return -1;
                }
                if(knows(ans, k,relations)){
                    return -1;
                }
            }
        }
        return ans;
    }
    private boolean knows(int a,int  b,int[][] relations){
        return relations[a][b]==1;
    }
}
public class LC277 {
    public static void main(String[] args) {

    }
}
