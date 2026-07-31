class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj =new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int [numCourses];
        for(int[]pre : prerequisites){
            adj.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }
        Queue<Integer> q= new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        int[] ans= new int[numCourses];
        int index=0;
        while(!q.isEmpty()){
            int node=q.poll();
            ans[index++]=node;
            for(int neighbour : adj.get(node)){
                indegree[neighbour]--;
                if(indegree[neighbour]==0){
                    q.offer(neighbour);
                }
            }
        }
        if(index != numCourses){
            return new int[0];
        }
        return ans;
    }
}