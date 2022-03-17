class Solution {
    Integer[][] memo;
    public int uniquePaths(int m, int n) {
        
        if (m == 1 || n == 1) {
            return 1;
        }
 
        
        memo = new Integer[m][n];
        memo[m - 1][n - 1] = 0;
        return solve(0,0);
        
        //number of possible ways will always be equal to 2 + number of ways from the position below
        // + number of ways from the position to the right.
    }
    
    public Integer solve(int m, int n) {
        
        if ((memo[m][n]) == null) { //if we haven't found it yet:
            
            memo[m][n] = 0; //
            if (m >= memo.length - 1) {
                memo[m][n] += 1;
                return memo[m][n];
            }
            
            if (n >= memo[0].length - 1) {
                memo[m][n] += 1;
                return memo[m][n];
            }
            
            else {
                memo[m][n] += solve(m + 1, n) + solve(m, n+1);
            }
            
        }
        
        return memo[m][n];
    } 
}
