class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] vis = new int[n];
        int[] pathVis = new int[n];
        int[] check = new int[n];
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                dfsCheck(i,graph,vis,pathVis,check);
            }}
            List<Integer> ans = new ArrayList<>();
             for (int i = 0; i < n; i++) {
            if (check[i] == 1) {
                ans.add(i);
            }
        }

        return ans;
    }
     public boolean dfsCheck(int node,
                            int[][] graph,
                            int[] vis,
                            int[] pathVis,
                            int[] check) {

        vis[node] = 1;
        pathVis[node] = 1;
        check[node] = 0;      // Assume unsafe initially

        for (int it : graph[node]) {

            // If neighbour is not visited
            if (vis[it] == 0) {

                if (dfsCheck(it, graph, vis, pathVis, check)) {
                    check[node] = 0;
                    return true;
                }
            }

            // If neighbour is in current DFS path
            else if (pathVis[it] == 1) {

                check[node] = 0;
                return true;
            }
        }

        // No cycle found
        check[node] = 1;      // Mark as safe
        pathVis[node] = 0;    // Remove from current path

        return false;
    }
        
    }
