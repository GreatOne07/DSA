class Solution {
    public String[] createGrid(int m, int n) {
        String[] grid=new String[m];
        StringBuilder fill=new StringBuilder();
        for(int i=0;i<n;i++){
            if(i==n-1) fill.append('.');
            else fill.append('#');
        }
        
        Arrays.fill(grid,fill.toString());
        StringBuilder change=new StringBuilder();
        for(int i=0;i<n;i++){
            
            change.append('.');
        }
        String change2=change.toString();
        grid[0]=change2;
        
        
        return grid;
    }
}