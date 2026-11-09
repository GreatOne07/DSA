class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int n = arrival.length;
        TreeSet<Integer> available_servers = new TreeSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]); // min heap -> completion_time, server_id , min over completion_time
        int[] server_used_count = new int[k];

        for(int i=0; i<k && i<n ; i++){
            pq.add(new int[]{arrival[i] + load[i], i});
            server_used_count[i]++;
        }


        for(int i=k; i<n; i++){
            int arrival_time = arrival[i];
            int complete_by = arrival[i] + load[i];
            int sever_number = i%k;
            // add all available servers to treeSet
            while(!pq.isEmpty() && pq.peek()[0] <= arrival_time){
                available_servers.add(pq.poll()[1]); // add server_id
            }

            if(available_servers.isEmpty()) continue;
            Integer server = available_servers.ceiling(sever_number);
            if(server == null){
                server = available_servers.first();
            }

            available_servers.remove(server);
            pq.add(new int[]{complete_by, server});
            server_used_count[server]++;  
        }

        int max = 0;
        for(int i=0; i<k; i++){
            max = Math.max(max, server_used_count[i]);
        }

        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<k; i++){
            if(server_used_count[i] == max)
                ans.add(i);
        }
        return ans;
    }
}