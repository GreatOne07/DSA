class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] pre:prerequisites){
            adj.get(pre[1]).add(pre[0]);
        }
        int vis[]=new int[numCourses];
        int[] pathVis = new int[numCourses];
        Stack<Integer> st=new Stack<>();
        for (int i = 0; i < numCourses; i++) {

            if (vis[i] == 0) {

                if (dfs(i, adj, vis, pathVis, st)) {
                    return new int[0];  
                }
            }
        }
         int[] ans = new int[numCourses];
        int index = 0;

        while (!st.isEmpty()) {
            ans[index++] = st.pop();
        }

        return ans;
    }
     public boolean dfs(int node,
                       ArrayList<ArrayList<Integer>> adj,
                       int[] vis,
                       int[] pathVis,
                       Stack<Integer> st) {

        vis[node] = 1;
        pathVis[node] = 1;

        for (int it : adj.get(node)) {

            if (vis[it] == 0) {

                if (dfs(it, adj, vis, pathVis, st)) {
                    return true;
                }

            } else if (pathVis[it] == 1) {
                return true; 
            }
        }

        pathVis[node] = 0;
        st.push(node);

        return false;
    }
}