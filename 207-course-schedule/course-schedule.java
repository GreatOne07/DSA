class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses; i++){
            adj.add(new ArrayList <>());}

            int[] indegree =new int[numCourses];

            for(int[] edge : prerequisites){
                int course =edge[0];
                int prereq = edge[1];

                adj.get(prereq).add(course);
                indegree[course]++;
            }
            Queue<Integer> q = new LinkedList <>();
            for(int i=0;i<numCourses;i++){
                if(indegree[i]==0){
                    q.offer(i);
                }}
                int count=0;
                while(!q.isEmpty()){
                    int node=q.poll();
                    count++;
                    for(int next : adj.get(node)){
                        indegree[next]--;
                        if(indegree[next]==0)
                        q.offer(next);
                    }
                }
                
            
        return count == numCourses;
    }
}