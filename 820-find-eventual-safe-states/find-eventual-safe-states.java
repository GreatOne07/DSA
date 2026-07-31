class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v = graph.length;
        ArrayList<ArrayList<Integer>> revAdj= new ArrayList<>();
        for(int i=0;i<v;i++){
            revAdj.add(new ArrayList<>());
        }
        int[] outdegree= new int[v];
        for(int i=0;i<v;i++){
            outdegree[i]=graph[i].length;
            for(int neighbour : graph[i]){
                revAdj.get(neighbour).add(i);
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for (int i = 0; i < v; i++) {

            if (outdegree[i] == 0) {

                q.offer(i);
            }}
             List<Integer> safeNodes = new ArrayList<>();

        while (!q.isEmpty()) {

            int node = q.poll();

            safeNodes.add(node);

            for (int neighbour : revAdj.get(node)) {

                outdegree[neighbour]--;

                if (outdegree[neighbour] == 0) {

                    q.offer(neighbour);
                }
            }
        }

        Collections.sort(safeNodes);

        return safeNodes;
        

    }

}