class Solution {
    
    class Pair {
        long first;
        int second;
        Pair(long first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public int countPaths(int n, int[][] roads) {
        //build graph
        ArrayList<ArrayList<Pair>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] it:roads){
            adj.get(it[0]).add(new Pair(it[2],it[1]));
            adj.get(it[1]).add(new Pair(it[2],it[0]));
        }
        //pq and arrays
        PriorityQueue<Pair>pq=new PriorityQueue<>((x,y)->Long.compare(x.first,y.first));
        long[]ways=new long[n];
        long[]dist=new long[n];
         int mod = (int)(1e9+7);
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0]=0;
        ways[0]=1;
        pq.add(new Pair(0,0));
         while(!pq.isEmpty()){

            Pair it = pq.poll();

            long dis = it.first;
            int node = it.second;

            for(Pair iter: adj.get(node)){

                long edW = iter.first;
                int adjNode = iter.second;

                if(dis + edW < dist[adjNode]){

                    dist[adjNode] = dis + edW;
                    ways[adjNode] = ways[node];

                    pq.add(new Pair(dist[adjNode], adjNode));
                }
                else if(dis + edW == dist[adjNode]){

                    ways[adjNode] =
                        (ways[adjNode] + ways[node]) % mod;
                }
            }
        }

        return (int)(ways[n-1] % mod);
    }
}