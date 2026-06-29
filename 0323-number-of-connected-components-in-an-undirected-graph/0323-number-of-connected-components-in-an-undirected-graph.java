class UF{
    int[] lead;
    int[] rank;
    UF(int numNodes){
        lead = new int[numNodes];
        rank = new int[numNodes];
        for(int i=0;i<lead.length;i++)
            lead[i] = i;

        Arrays.fill(rank, 1);
    }
    int find(int node){
        if(lead[node]==node)
            return node;
        else{
            lead[node] = find(lead[node]);
            return lead[node];
        }
    }

    boolean union(int node1, int node2){
        int node1lead = find(node1);
        int node2lead = find(node2);
        if(node1lead==node2lead)
            return false;

        if(rank[node1lead] > rank[node2lead]){
            lead[node2lead] = node1lead;
            rank[node1lead] += rank[node2lead];
        }else{
            lead[node1lead] = node2lead;
            rank[node2lead]+=rank[node1lead];
        }
        return true;
    }
}


class Solution {
    public int countComponents(int n, int[][] edges) {
        UF uf = new UF(n);
        int ret = n;
        for(int[] edge: edges){
            if(uf.union(edge[0], edge[1]))
                ret--;
        }
        return ret; 
    }
}