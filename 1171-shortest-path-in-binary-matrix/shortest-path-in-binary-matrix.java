class Solution {
    class Pair{
        int row;
        int col;
        int dist;
        Pair(int r,int c,int d){
            row=r;
            col=c;
            dist=d;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n =grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1){
            return -1;
        }
        Queue<Pair> q=new LinkedList<>();
        boolean [][] vis=new boolean[n][n];
        q.offer(new Pair(0,0,1));
        vis[0][0]=true;
        int[] dr={-1,-1,-1,0,0,1,1,1};
        int[] dc={-1,0,1,-1,1,-1,0,1};
        while(!q.isEmpty()){
            Pair curr=q.poll();
            int r=curr.row;
            int c=curr.col;
            int d=curr.dist;
            if(r==n-1 && c==n-1){
                return d;
            }
            for(int i=0;i<8;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];
                if(nr>=0 && nr<n && nc>=0 && nc<n && grid[nr][nc]==0 && !vis[nr][nc]){
                    vis[nr][nc]=true;
                    q.offer(new Pair(nr,nc,d+1));
                }
            }
        }
        return -1;
    }
}