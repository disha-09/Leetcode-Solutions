class Solution {
    public int[] findBall(int[][] grid) {
        int ans[] = new int[grid[0].length];
        
        for(int j = 0; j < grid[0].length; j++){
            int curcol = j;
           
            for(int i = 0; i < grid.length; i++){
               int newcol = curcol + grid[i][curcol];
            
                if(newcol < 0 ||
                    newcol > grid[0].length - 1 ||
                    grid[i][newcol] != grid[i][curcol]){
                    
                    ans[j] = -1;
                    break;
                }
                ans[j] = newcol;
                curcol = newcol;   
            }
        }
        
        return ans;
    }
}